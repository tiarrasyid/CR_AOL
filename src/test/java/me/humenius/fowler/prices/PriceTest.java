package me.humenius.fowler.prices;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

public class PriceTest {
    @Test
    public void testChildrenPriceCalculation() {
        Price price = new ChildrenPrice();
        int daysRented = 5;
        double actual = price.getCharge(daysRented);
        double expected = 1.5 + (((double) daysRented) - 3) * 1.5;
        assertEquals(actual, expected);
    }

    @Test
    public void testNewReleasePriceCalculation() {
        Price price = new NewReleasePrice();
        int daysRented = 5;
        double actual = price.getCharge(daysRented);
        double expected = (double) daysRented * 3;
        assertEquals(actual, expected);
    }

    @Test
    public void testRegularPriceCalculation() {
        Price price = new RegularPrice();
        int daysRented = 5;
        double actual = price.getCharge(daysRented);
        double expected = 2.0 + (((double) daysRented) - 2) * 1.5;
        assertEquals(actual, expected);
    }

    @Test
    public void testRegularPriceFrequentRenterPoints() {
        Price price = new RegularPrice();
        int daysRented = 5;
        int actual = price.getFrequentRenterPoints(daysRented);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testNewReleasePriceFrequentRenterPoints() {
        Price price = new NewReleasePrice();
        int daysRented = 5;
        int actual = price.getFrequentRenterPoints(daysRented);
        int expected = 2;
        assertEquals(actual, expected);
    }
}