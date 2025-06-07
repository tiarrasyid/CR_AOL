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

package me.humenius.fowler.prices;

public class NewReleasePrice extends Price {
    private static NewReleasePrice instance;

    private NewReleasePrice() {}

    public static NewReleasePrice getInstance() {
        if (instance == null) {
            instance = new NewReleasePrice();
        }
        return instance;
    }

    @Override 
    public double getBaseCharge() { 
        return 0.0; 
    }

    @Override 
    public int getThresholdDays() { 
        return 0; 
    }

    @Override 
    public double getSurchargePerDay() { 
        return 3.0; 
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
