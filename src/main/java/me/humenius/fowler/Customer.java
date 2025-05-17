// package me.humenius.fowler;

// import java.util.*;

// /**
//  * <h1>Customer</h1>
//  * <p>Representation of a possible customer.</p>
//  */
// class Customer {
//     private final String name;
//     private final List<Rental> rentals = new ArrayList<>();

//     Customer(String name) {
//         this.name = name;
//     }

//     /**
//      * @param   rental  Movie to add to one customer's rental list
//      */
//     public void addRental(Rental rental) {
//         rentals.add(rental);
//     }

//     /**
//      * @return  A statement including all rented movies, their charges and total possible earned frequent renter points.
//      */
//     public String getStatement() {
//         StringBuilder statement = new StringBuilder();
//         statement.append("Rental Record for ")
//                  .append(name)
//                  .append("\n\t")
//                  .append("Title")
//                  .append("\t\t")
//                  .append("Days")
//                  .append('\t')
//                  .append("Amount")
//                  .append('\n');

//         for (Rental rental : rentals) {
//             statement.append('\t')
//                      .append(rental.getMovie()
//                                    .getTitle())
//                      .append('\t')
//                      .append('\t')
//                      .append(rental.getDaysRented())
//                      .append('\t')
//                      .append('\t')
//                      .append(rental.getCharge())
//                      .append('\n');
//         }

//         statement.append("Amount owed is ")
//                  .append(getTotalCharge())
//                  .append('\n')
//                  .append("You earned ")
//                  .append(getTotalFrequentRenterPoints())
//                  .append(" frequent renter points");

//         return statement.toString();
//     }

//     private double getTotalCharge() {
//         double total = 0.0;

//         for (Rental rental : rentals) {
//             total += rental.getCharge();
//         }

//         return total;
//     }

//     private int getTotalFrequentRenterPoints() {
//         int total = 0;

//         for (Rental rental : rentals) {
//             total += rental.getFrequentRenterPoints();
//         }

//         return total;
//     }
// }

// ✅ Code Smell yang Ditemukan
// Long Method → getStatement() terlalu panjang dan mencampur formatting dengan logic.
// Feature Envy → Customer terlalu banyak mengakses Movie melalui Rental.
// Magic String/Primitive Obsession → Hardcoded format di getStatement().
// Duplication → Perulangan format dan logika perhitungan.

// ✅ Refactor Goals
// Ekstraksi method untuk meningkatkan keterbacaan.
// Hindari logika pencetakan yang tercampur dengan logika bisnis.
// Gunakan String.format() agar lebih terstruktur.


package me.humenius.fowler;

import java.util.*;

/**
 * <h1>Customer</h1>
 * <p>Representation of a possible customer.</p>
 */
class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append(getHeader());

        for (Rental rental : rentals) {
            statement.append(formatRentalLine(rental));
        }

        statement.append(getFooter());

        return statement.toString();
    }

    private String getHeader() {
        return String.format("Rental Record for %s\n\tTitle\t\tDays\tAmount\n", name);
    }

    private String formatRentalLine(Rental rental) {
        return String.format("\t%s\t\t%d\t\t%.2f\n",
                rental.getMovie().getTitle(),
                rental.getDaysRented(),
                rental.getCharge());
    }

    private String getFooter() {
        return String.format("Amount owed is %.2f\nYou earned %d frequent renter points",
                getTotalCharge(),
                getTotalFrequentRenterPoints());
    }

    private double getTotalCharge() {
        return rentals.stream()
                      .mapToDouble(Rental::getCharge)
                      .sum();
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream()
                      .mapToInt(Rental::getFrequentRenterPoints)
                      .sum();
    }
}
  