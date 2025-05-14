// sebelum
// package me.humenius.fowler.prices;

// /**
//  * <h1>Price</h1>
//  * <p>An interface whose classes should provide functionality for charge and rental points calculation.</p>
//  */
// public abstract class Price {
//     /**
//      * Get charge which can be calculated from each class independently.
//      * @param   daysRented  Amount of days the movie has been rented
//      * @return  Total charge of a rental
//      */
//     public abstract double getCharge(int daysRented);

//     /**
//      * @param   daysRented  Amount of days the movie has been rented
//      * @return  Total amount of possible renter points
//      */
//     public int getFrequentRenterPoints(int daysRented) {
//         return 1;
//     }
// }

// Smell	Penjelasan
// Misleading JavaDoc for Price	JavaDoc menyebut "interface", padahal class ini adalah abstract class. Ini dapat membingungkan pembaca atau developer lain.
// Lack of final for class	Jika kelas ini tidak dimaksudkan untuk diinstansiasi langsung (hanya untuk inheritance), maka sebaiknya gunakan modifier abstract final atau disertai keterangan yang lebih tegas.
// Hardcoded return value	Fungsi getFrequentRenterPoints() selalu mengembalikan 1, tanpa indikasi bahwa ini adalah default behavior yang bisa di-override. Komentar bisa ditambahkan untuk memperjelas.

// Perubahan	Tujuan
// Update JavaDoc	Sesuaikan dokumentasi agar merefleksikan bahwa ini adalah abstract class, bukan interface.
// Tambahkan klarifikasi getFrequentRenterPoints()	Jelaskan bahwa ini default implementation dan bisa di-override oleh subclass.
// Tambahkan protected constructor (opsional)	Mencegah instansiasi langsung dari luar class (jika perlu).



// sesudah
package me.humenius.fowler.prices;

/**
 * <h1>Price</h1>
 * <p>Abstract base class for calculating rental charges and frequent renter points.</p>
 * <p>Each subclass should implement its own charging logic.</p>
 */
public abstract class Price {

    /**
     * Protected constructor to prevent direct instantiation.
     */
    protected Price() {}

    /**
     * Calculate the total rental charge based on number of days rented.
     * Each subclass implements its own logic.
     *
     * @param daysRented Number of days the movie has been rented
     * @return Total charge of a rental
     */
    public abstract double getCharge(int daysRented);

    /**
     * Default frequent renter point logic.
     * Subclasses may override this method to implement bonus point rules.
     *
     * @param daysRented Number of days the movie has been rented
     * @return Total frequent renter points
     */
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
