// package me.humenius.fowler;

// import me.humenius.fowler.prices.ChildrenPrice;
// import me.humenius.fowler.prices.NewReleasePrice;

// /**
//  * Note that Java console applications need to be run through the java runtime
//  * by running "java -jar JarFile.jar" in the command line.
//  * Java console applications can not be previewed in the Compilr IDE, only applets can.
//  */
// public class Program {
//     /**
//      * This is the main entry point for the application
//      */

//     @SuppressWarnings("java:S106")
//     public static void main(String[] args) {
//         String result;
//         System.out.println("Welcome to the Movie Store");
//         Movie m1 = new Movie("movie1", NewReleasePrice.getInstance());
//         Movie m2 = new Movie("movie2", ChildrenPrice.getInstance());
//         Rental r1 = new Rental(m1, 10);
//         Rental r2 = new Rental(m2, 5);
//         Customer c1 = new Customer("joe");
//         c1.addRental(r1);
//         c1.addRental(r2);
//         System.out.println("Let's get the Statement");
//         result = c1.getStatement();
//         System.out.println(result);
//     }
// }

package me.humenius.fowler;

import me.humenius.fowler.prices.ChildrenPrice;
import me.humenius.fowler.prices.NewReleasePrice;

public class Program {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        String result;
        System.out.println("Welcome to the Movie Store");
        Movie m1 = new Movie("movie1", NewReleasePrice.getInstance());
        Movie m2 = new Movie("movie2", ChildrenPrice.getInstance());
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(r1);
        c1.addRental(r2);
        System.out.println("Let's get the Statement");
        result = c1.getStatement();
        System.out.println(result);
    }
}
