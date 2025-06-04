package me.humenius.fowler;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import me.humenius.fowler.prices.ChildrenPrice;
import me.humenius.fowler.prices.NewReleasePrice;

public class RentalTest {
    @Test
    public void testGetChargeWithNewReleasePrice() {

        // Primitive Obsession (Code Smell)
        // Reason: Penggunaan int daysRented secara primitif berulang tanpa pembungkusan, sehingga nilai ini tersebar dan bisa terjadi inkonsistensi.
        // Refactoring Technique: Introduce Parameter Object

        // before
        // int daysRented = 10;
        // Movie movie = new Movie("Test movie with new release pricing", NewReleasePrice.getInstance());
        // Rental rental = new Rental(movie, daysRented);

        // double actual = rental.getCharge();
        // double expected = (double) daysRented * 3;
        // assertEquals(expected, actual);

        // after
        int daysRented = 5;
        RentalPeriod rentalPeriod = new RentalPeriod(daysRented);
        Movie movie = new Movie("Test movie with children price", ChildrenPrice.getInstance());
        Rental rental = new Rental(movie, rentalPeriod.getDays());

        double actual = rental.getCharge();
        double expected = 1.5 + (rentalPeriod.getDays() - 3) * 1.5;
        assertEquals(expected, actual);

    }

    @Test
    public void testGetChargeWithChildrenPrice() {
        int daysRented = 5;
        Movie movie = new Movie("Test movie with children price", ChildrenPrice.getInstance());
        Rental rental = new Rental(movie, daysRented);

        double actual = rental.getCharge();
        double expected = 1.5 + (((double) daysRented) - 3) * 1.5;
        assertEquals(expected, actual);
    }
}
