public class Main {
    public static void main(String[] args) {
        Slot slot = new Slot(3, 10);
        slot.createSymbols();
//        slot.spin();

        int totalSpinsCounter = 0;

        for (int i = 0; i < 10000; i++) {
            int spinCounter = 0;
            while (!slot.spin())
                ++spinCounter;

//            System.out.println(spinCounter);
            totalSpinsCounter += spinCounter;
        }

        System.out.println(totalSpinsCounter / 10000.0);
    }
}