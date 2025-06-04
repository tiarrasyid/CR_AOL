package me.humenius.fowler.prices;

// before
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

// 1. Singleton (Code Smell)
// Reason:
// RegularPrice menggunakan singleton pattern yang tidak thread-safe, sehingga dapat menimbulkan multiple instance pada lingkungan multi-threaded.

// Refactoring Technique:
// Gunakan teknik Double-Checked Locking atau Initialization-on-demand holder idiom agar singleton menjadi aman di multithreaded environment.

//after
public class RegularPrice extends Price {
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
        double total = 2.0;
        if (daysRented > 2) {
            total += (daysRented - 2) * 1.5;
        }
        return total;
    }
}
