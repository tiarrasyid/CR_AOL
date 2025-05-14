// sebelum
// package me.humenius.fowler.prices;

// public class ChildrenPrice extends Price {
//     private static ChildrenPrice instance;

//     private ChildrenPrice() {}

//     public static ChildrenPrice getInstance() {
//         if (instance == null) {
//             instance = new ChildrenPrice();
//         }

//         return instance;
//     }

//     @Override
//     public double getCharge(int daysRented) {
//         double total = 1.5;

//         if (daysRented > 3) {
//             total += (daysRented - 3) * 1.5;
//         }

//         return total;
//     }
// }

// kesalahan sebelumnya:
// Lazy Initialization Singleton (Thread-unsafe):
// ChildrenPrice.getInstance() menggunakan pola singleton yang tidak thread-safe, bisa bermasalah saat dipakai dalam lingkungan multithreaded.

// Magic Number:
// Nilai seperti 1.5 dan 3 digunakan tanpa konstan, membuat kode sulit dipahami dan tidak fleksibel.

// Method getCharge masih mengandung logika bercabang:
// Meski pendek, bisa dibuat lebih ekspresif dengan mengganti if-statement menjadi pendekatan yang lebih jelas.

// perbaikan:
// Extract Constant	Semua nilai magic number diubah menjadi konstanta: BASE_CHARGE, BASE_DAYS, EXTRA_CHARGE_PER_DAY.
// Singleton Thread-safe	Menggunakan Initialization-on-demand holder idiom, pola singleton yang efisien dan thread-safe.
// Simplified Logic	Struktur if ditulis lebih bersih dan ekspresif.

// sesudah
package me.humenius.fowler.prices;

public class ChildrenPrice extends Price {
    private static final double BASE_CHARGE = 1.5;
    private static final int BASE_DAYS = 3;
    private static final double EXTRA_CHARGE_PER_DAY = 1.5;

    // Thread-safe singleton with initialization-on-demand holder idiom
    private ChildrenPrice() {}

    private static class Holder {
        private static final ChildrenPrice INSTANCE = new ChildrenPrice();
    }

    public static ChildrenPrice getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public double getCharge(int daysRented) {
        if (daysRented <= BASE_DAYS) {
            return BASE_CHARGE;
        }
        return BASE_CHARGE + (daysRented - BASE_DAYS) * EXTRA_CHARGE_PER_DAY;
    }
}
