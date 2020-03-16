public class Main {
    public static void main(String[] args) {
        Slot slot = new Slot(3, 11);

//        slot.spin();

        int numberOfTests = 10000;
        int totalSpinsCounter = 0;

        for (int i = 0; i < numberOfTests; i++) {
            int spinsCounter = 0;
            while (!slot.spin())
                ++spinsCounter;

//            System.out.println(spinsCounter);
            totalSpinsCounter += spinsCounter;
        }

        System.out.println((double) totalSpinsCounter / numberOfTests);
    }
}