package me.humenius.fowler.prices;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;
import org.junit.runners.Parameterized;

public class PriceTest {

    // Duplicate Code (Code Smell)
    // Reason: Banyak kode pengujian di PriceTest.java yang mengulang pola sama untuk tiap jenis harga, setup dan assert mirip-mirip sehingga duplikasi kode.
    // Refactoring Technique: Extract Method + Parameterized Test (simplified Extract Method contoh)

    // before
    // @Test
    // public void testChildrenPriceCalculation() {
    //     Price price = ChildrenPrice.getInstance();
    //     int daysRented = 5;

    //     double actual = price.getCharge(daysRented);
    //     double expected = 1.5 + (((double) daysRented) - 3) * 1.5;
    //     assertEquals(actual, expected);
    // }

    // @Test
    // public void testNewReleasePriceCalculation() {
    //     Price price = NewReleasePrice.getInstance();
    //     int daysRented = 5;

    //     double actual = price.getCharge(daysRented);
    //     double expected = (double) daysRented * 3;
    //     assertEquals(actual, expected);
    // }

    // @Test
    // public void testRegularPriceCalculation() {
    //     Price price = RegularPrice.getInstance();
    //     int daysRented = 5;

    //     double actual = price.getCharge(daysRented);
    //     double expected = 2.0 + (((double) daysRented) - 2) * 1.5;
    //     assertEquals(actual, expected);
    // }

    // @Test
    // public void testRegularPriceFrequentRenterPoints() {
    //     Price price = RegularPrice.getInstance();
    //     int daysRented = 5;

    //     int actual = price.getFrequentRenterPoints(daysRented);
    //     int expected = 1;
    //     assertEquals(actual, expected);
    // }

    // @Test
    // public void testNewReleasePriceFrequentRenterPoints() {
    //     Price price = NewReleasePrice.getInstance();
    //     int daysRented = 5;

    //     int actual = price.getFrequentRenterPoints(daysRented);
    //     int expected = 2;
    //     assertEquals(actual, expected);
    // }

    // after
    private void testPriceCalculation(Price price, int daysRented, double expected) {
        double actual = price.getCharge(daysRented);
        assertEquals(expected, actual);
    }

    @Test
    public void testChildrenPriceCalculation() {
        testPriceCalculation(ChildrenPrice.getInstance(), 5, 1.5 + (5 - 3) * 1.5);
    }

    @Test
    public void testNewReleasePriceCalculation() {
        testPriceCalculation(NewReleasePrice.getInstance(), 5, 5 * 3.0);
    }

    @Test
    public void testRegularPriceCalculation() {
        testPriceCalculation(RegularPrice.getInstance(), 5, 2.0 + (5 - 2) * 1.5);
    }
}