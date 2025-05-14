// sebelum
// package me.humenius.fowler.prices;

// public class RegularPrice extends Price {
//     private static RegularPrice instance;

//     private RegularPrice() {}

//     public static RegularPrice getInstance() {
//         if (instance == null) {
//             instance = new RegularPrice();
//         }

//         return instance;
//     }

//     @Override
//     public double getCharge(int daysRented) {
//         double total = 2.0;

//         if (daysRented > 2) {
//             total += (daysRented - 2) * 1.5;
//         }

//         return total;
//     }
// }

// | Code Smell                         | Penjelasan                                                                                                                                                  |
// | ---------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------- |
// | **Lazy Singleton (Thread-unsafe)** | Penggunaan pola singleton tanpa sinkronisasi bersifat **tidak aman** dalam lingkungan multi-thread.                                                         |
// | **Duplicated Singleton Logic**     | Implementasi pola singleton ini **berulang di banyak class** (`ChildrenPrice`, `NewReleasePrice`, dll) — ini melanggar prinsip DRY (Don't Repeat Yourself). |
// | **Magic Numbers**                  | Nilai `2.0` dan `1.5` muncul tanpa penjelasan (lebih baik gunakan konstanta atau dokumentasi).                                                              |

// | Perubahan                                                                                          | Alasan                                                                   |
// | -------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------ |
// | Menggunakan **`volatile`** dan **`synchronized`**                                                  | Membuat Singleton menjadi thread-safe (Double-Checked Locking).          |
// | Menggunakan konstanta                                                                              | Meningkatkan keterbacaan dan mempermudah modifikasi nilai di masa depan. |


// sesudah
package me.humenius.fowler.prices;

public class RegularPrice extends Price {

    private static final double BASE_CHARGE = 2.0;
    private static final double EXTRA_CHARGE = 1.5;
    private static final int BASE_DAYS = 2;

    private static volatile RegularPrice instance;

    private RegularPrice() {}

    public static RegularPrice getInstance() {
        if (instance == null) {
            synchronized (RegularPrice.class) {
                if (instance == null) {
                    instance = new RegularPrice();
                }
            }
        }

        return instance;
    }

    @Override
    public double getCharge(int daysRented) {
        double total = BASE_CHARGE;

        if (daysRented > BASE_DAYS) {
            total += (daysRented - BASE_DAYS) * EXTRA_CHARGE;
        }

        return total;
    }
}
