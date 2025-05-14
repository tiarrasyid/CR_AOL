package me.humenius.fowler;

/**
 * <h1>Rental</h1>
 * <p>Entity which represents a movie rental.</p>
 */
class Rental {
    private final Movie movie;
    private final int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    /**
     * @return  Charge of movie based of days rented.
     */
    public double getCharge() { return movie.getCharge(daysRented); }

    /**
     * @return  Frequent renter points of movie based of days rented.
     */
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}