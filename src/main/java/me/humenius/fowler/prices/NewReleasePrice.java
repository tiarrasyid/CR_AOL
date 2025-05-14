// sebelum
// package me.humenius.fowler.prices;

// public class NewReleasePrice extends Price {
//     private static NewReleasePrice instance;

//     private NewReleasePrice() {}

//     public static NewReleasePrice getInstance() {
//         if (instance == null) {
//             instance = new NewReleasePrice();
//         }

//         return instance;
//     }

//     @Override
//     public double getCharge(int daysRented) {
//         return (daysRented * 3);
//     }

//     @Override
//     public int getFrequentRenterPoints(int daysRented) {
//         return (daysRented > 1) ? 2 : 1;
//     }
// }

// Smell	Penjelasan
// Lazy Initialization (Thread-unsafe Singleton)	Singleton menggunakan lazy init biasa (if (instance == null)), tetapi tidak thread-safe. Bisa menimbulkan multiple instances di lingkungan multithread.
// Magic Number	Angka 3 dan 2 muncul tanpa penjelasan. Ini membuat kode kurang jelas dan sulit dipelihara.
// Lack of Constant Extraction	Angka 3 dan 2 bisa dijadikan konstanta agar lebih readable dan maintainable.

// Refactor	Penjelasan
// Thread-safe Singleton (Holder idiom)	Mengganti pattern singleton ke Initialization-on-demand holder idiom. Lebih efisien dan aman untuk multithreading.
// Constant Extraction	Menjadikan nilai 3 dan 2 sebagai named constants.
// Improved Readability	Penambahan nama konstan dan perbaikan struktur menjadikan kode lebih jelas dan lebih mudah dipahami.

// sesudah
package me.humenius.fowler.prices;

public class NewReleasePrice extends Price {
    private static final double CHARGE_PER_DAY = 3.0;
    private static final int BONUS_POINT_THRESHOLD = 1;
    private static final int BONUS_POINTS = 2;
    private static final int DEFAULT_POINTS = 1;

    private NewReleasePrice() {}

    private static class Holder {
        private static final NewReleasePrice INSTANCE = new NewReleasePrice();
    }

    public static NewReleasePrice getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * CHARGE_PER_DAY;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > BONUS_POINT_THRESHOLD) ? BONUS_POINTS : DEFAULT_POINTS;
    }
}
