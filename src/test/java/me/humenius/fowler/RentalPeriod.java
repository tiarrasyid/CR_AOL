package me.humenius.fowler;

// RentalPeriod.java (bisa di file terpisah)
public class RentalPeriod {
    private final int days;

    public RentalPeriod(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
