import java.util.Arrays;

public class Slot {
    private int[][] reels;
    private int numberOfSymbols;
//    int[][] reels = {
//            {2, 4, 1},
//            {1, 1, 3},
//            {1, 2, 5}
//    };

    public Slot(int reelRowsAndColumns, int numberOfSymbols) {
        reels = new int[reelRowsAndColumns][reelRowsAndColumns];
        this.numberOfSymbols = numberOfSymbols;
    }

    public boolean spin() {
        int[] symbols = new int[numberOfSymbols];

        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = i;
        }

        for (int i = 0; i < reels.length; i++) {
            for (int j = 0; j < reels[i].length; j++) {
                reels[i][j] = symbols[(int) (Math.random() * symbols.length)];
            }
        }

        boolean horizontal = checkWinnerHorizontal();
        boolean diagonal = checkWinnerDiagonal();
        boolean antidiagonal = checkWinnerAntidiagonal();

//        if (horizontal)
//            System.out.println("H");
//
//        if (diagonal)
//            System.out.println("D");
//
//        if (antidiagonal)
//            System.out.println("A");

//        if (horizontal || diagonal || antidiagonal)
//            printIt();

        return horizontal || diagonal || antidiagonal;
    }

    public void printIt() {
        for (int i = 0; i < reels.length; i++) {
            System.out.println(Arrays.toString(reels[i]));
        }

        System.out.println();
    }

    public boolean checkWinnerHorizontal() {
        for (int i = 0; i < reels.length; i++) {
            int firstSymbol = 0;
            for (int j = 0; j < reels[i].length; j++) {
                if (j == 0)
                    firstSymbol = reels[i][j];
                else if (reels[i][j] != firstSymbol)
                    break;
                else if (j == reels[i].length - 1)
                    return true;
            }
        }

        return false;
    }

    public boolean checkWinnerDiagonal() {
        int firstSymbol = 0;

        for (int i = 0; i < reels.length; i++) {
            if (i == 0)
                firstSymbol = reels[i][i];
            else if (reels[i][i] != firstSymbol)
                break;
            else if (i == reels[i].length - 1)
                return true;
        }

        return false;
    }

    public boolean checkWinnerAntidiagonal() {
        int firstSymbol = 0;

        for (int i = 0, j = reels.length - 1; i < reels.length; i++, j--) {
            if (i == 0)
                firstSymbol = reels[i][j];
            else if (reels[i][j] != firstSymbol)
                break;
            else if (i == reels[i].length - 1)
                return true;
        }

        return false;
    }
}
