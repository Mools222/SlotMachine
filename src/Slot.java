import java.util.Arrays;

public class Slot {
        private char[][] reels;
//    char[][] reels = {
//            {'w', '2', '2'},
//            {'5', '8', '1'},
//            {'5', '2', '6'}
//    };
    private char[] symbols;
    private int wild = 'w';

    public Slot(int reelRowsAndColumns, int numberOfSymbols) {
        reels = new char[reelRowsAndColumns][reelRowsAndColumns];
        createSymbols(numberOfSymbols);
    }

    public void createSymbols(int numberOfSymbols) {
        symbols = new char[numberOfSymbols];
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = (char) (i + 33); // Start from 33 to get some nice symbols (33 = !) (see an ASCII table).
        }
        symbols[symbols.length - 1] = 'w'; // Note that wild is set to w (which is number 119), so if you pick more than 87 symbols, you're going to get incorrect results
    }

    public boolean spin() {
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
//
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
            char firstSymbol = '\u0000';

            for (int j = 0; j < reels[i].length; j++) {
                if (firstSymbol == '\u0000') {
                    if (reels[i][j] != wild)
                        firstSymbol = reels[i][j];
                } else if (reels[i][j] != firstSymbol && reels[i][j] != wild)
                    break;
                else if (j == reels[i].length - 1)
                    return true;
            }
        }

        return false;
    }

    public boolean checkWinnerDiagonal() {
        char firstSymbol = '\u0000';

        for (int i = 0; i < reels.length; i++) {
            if (firstSymbol == '\u0000') {
                if (reels[i][i] != wild)
                    firstSymbol = reels[i][i];
            } else if (reels[i][i] != firstSymbol && reels[i][i] != wild)
                break;
            else if (i == reels[i].length - 1)
                return true;
        }

        return false;
    }

    public boolean checkWinnerAntidiagonal() {
        char firstSymbol = '\u0000';

        for (int i = 0, j = reels.length - 1; i < reels.length; i++, j--) {
            if (firstSymbol == '\u0000') {
                if (reels[i][j] != wild)
                    firstSymbol = reels[i][j];
            } else if (reels[i][j] != firstSymbol && reels[i][j] != wild)
                break;
            else if (i == reels[i].length - 1)
                return true;
        }

        return false;
    }
}