// package me.humenius.fowler.prices;

// import static junit.framework.TestCase.assertEquals;

// import org.junit.Test;

// public class PriceTest {
//     @Test
//     public void testChildrenPriceCalculation() {
//         Price price = ChildrenPrice.getInstance();
//         int daysRented = 5;

//         double actual = price.getCharge(daysRented);
//         double expected = 1.5 + (((double) daysRented) - 3) * 1.5;
//         assertEquals(actual, expected);
//     }

//     @Test
//     public void testNewReleasePriceCalculation() {
//         Price price = NewReleasePrice.getInstance();
//         int daysRented = 5;

//         double actual = price.getCharge(daysRented);
//         double expected = (double) daysRented * 3;
//         assertEquals(actual, expected);
//     }

//     @Test
//     public void testRegularPriceCalculation() {
//         Price price = RegularPrice.getInstance();
//         int daysRented = 5;

//         double actual = price.getCharge(daysRented);
//         double expected = 2.0 + (((double) daysRented) - 2) * 1.5;
//         assertEquals(actual, expected);
//     }

//     @Test
//     public void testRegularPriceFrequentRenterPoints() {
//         Price price = RegularPrice.getInstance();
//         int daysRented = 5;

//         int actual = price.getFrequentRenterPoints(daysRented);
//         int expected = 1;
//         assertEquals(actual, expected);
//     }

//     @Test
//     public void testNewReleasePriceFrequentRenterPoints() {
//         Price price = NewReleasePrice.getInstance();
//         int daysRented = 5;

//         int actual = price.getFrequentRenterPoints(daysRented);
//         int expected = 2;
//         assertEquals(actual, expected);
//     }
// }

package me.humenius.fowler.prices;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PriceTest {
    // Refactor Note:
    // Code Smell: Magic Number
    // -> Nilai seperti 5, 3, dan 2 digunakan langsung dalam beberapa test.
    // -> Perubahan: Didefinisikan sebagai konstanta agar lebih mudah dipahami dan diubah.
    private static final int TEST_DAYS_RENTED = 5;

    @Test
    public void testChildrenPriceCalculation() {
        // Code Smell: Magic Number + Assertion Without Delta
        // -> Perubahan: Gunakan konstanta dan tambahkan delta pada assertEquals untuk akurasi float
        Price price = ChildrenPrice.getInstance();
        double expected = 1.5 + (TEST_DAYS_RENTED - 3) * 1.5;
        assertEquals(expected, price.getCharge(TEST_DAYS_RENTED), 0.001);
    }

    @Test
    public void testNewReleasePriceCalculation() {
        Price price = NewReleasePrice.getInstance();
        double expected = TEST_DAYS_RENTED * 3;
        assertEquals(expected, price.getCharge(TEST_DAYS_RENTED), 0.001);
    }

    @Test
    public void testRegularPriceCalculation() {
        Price price = RegularPrice.getInstance();
        double expected = 2.0 + (TEST_DAYS_RENTED - 2) * 1.5;
        assertEquals(expected, price.getCharge(TEST_DAYS_RENTED), 0.001);
    }

    @Test
    public void testRegularPriceFrequentRenterPoints() {
        // Code Smell: Repetition
        // -> Perubahan: Gunakan konstanta TEST_DAYS_RENTED agar konsisten
        Price price = RegularPrice.getInstance();
        assertEquals(1, price.getFrequentRenterPoints(TEST_DAYS_RENTED));
    }

    @Test
    public void testNewReleasePriceFrequentRenterPoints() {
        Price price = NewReleasePrice.getInstance();
        assertEquals(2, price.getFrequentRenterPoints(TEST_DAYS_RENTED));
    }
}

// Refactor Summary:
// - Code Smell: Magic Number -> Ganti dengan constant TEST_DAYS_RENTED
// - Code Smell: Assertion Without Delta -> Tambahkan delta pada perbandingan double
// - Code Smell: Repetitive Code -> Gunakan variable constant untuk DRY
// - Code Smell: Outdated JUnit Import -> Ubah ke org.junit.Assert.assertEquals
