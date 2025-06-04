
package me.humenius.fowler.prices;

public class ChildrenPrice extends Price {
    // after
    private static final double BASE_CHARGE = 2.0;
    private static final int BONUS_THRESHOLD = 2;
    private static final double BONUS_RATE = 1.5;

    private static ChildrenPrice instance;

    private ChildrenPrice() {}

    public static ChildrenPrice getInstance() {
        if (instance == null) {
            instance = new ChildrenPrice();
        }

        return instance;
    }

    @Override
    public double getCharge(int daysRented) {

        // 2. Magic Numbers (Code Smell)
        // Reason:
        // Penggunaan angka literal seperti 2.0, 2, dan 1.5 tanpa makna yang jelas dapat menyulitkan pemeliharaan dan tidak menjelaskan tujuan dari angka tersebut.

        // Refactoring Technique:
        // Ganti angka literal dengan konstanta bernama yang mendeskripsikan maksud nilai tersebut.

        //before
        // double total = 1.5;

        // if (daysRented > 3) {
        //     total += (daysRented - 3) * 1.5;
        // }

        // after
        double total = BASE_CHARGE;
        if (daysRented > BONUS_THRESHOLD) {
             total += (daysRented - BONUS_THRESHOLD) * BONUS_RATE;
        }

        return total;
    }
}