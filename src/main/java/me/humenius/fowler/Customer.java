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

    /**
     * @param   rental  Movie to add to one customer's rental list
     */
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    /**
     * @return  A statement including all rented movies, their charges and total possible earned frequent renter points.
     */
    public String getStatement() {

        // 1. Long Method (Code Smell)
        // Reason:
        // Metode getStatement() di kelas Customer terlalu panjang dan melakukan banyak tanggung jawab sekaligus (membangun teks, menghitung biaya, dan poin), sehingga sulit dibaca dan dipelihara.

        // Refactoring Technique:
        // Extract Method

        // before
        // StringBuilder statement = new StringBuilder();
        // statement.append("Rental Record for ")
        //          .append(name)
        //          .append("\n\t")
        //          .append("Title")
        //          .append("\t\t")
        //          .append("Days")
        //          .append('\t')
        //          .append("Amount")
        //          .append('\n');

        // for (Rental rental : rentals) {
        //     statement.append('\t')
        //              .append(rental.getMovie()
        //                            .getTitle())
        //              .append('\t')
        //              .append('\t')
        //              .append(rental.getDaysRented())
        //              .append('\t')
        //              .append('\t')
        //              .append(rental.getCharge())
        //              .append('\n');
        // }

        // statement.append("Amount owed is ")
        //          .append(getTotalCharge())
        //          .append('\n')
        //          .append("You earned ")
        //          .append(getTotalFrequentRenterPoints())
        //          .append(" frequent renter points");

        // return statement.toString();

        // after
        return new StatementBuilder(this).build();
    }

    double getTotalCharge() {
        double total = 0.0;

        for (Rental rental : rentals) {
            total += rental.getCharge();
        }

        return total;
    }

    int getTotalFrequentRenterPoints() {
        int total = 0;

        for (Rental rental : rentals) {
            total += rental.getFrequentRenterPoints();
        }

        return total;
    }

    public Object getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public Rental[] getRentals() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRentals'");
    }
}