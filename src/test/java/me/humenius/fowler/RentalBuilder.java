package me.humenius.fowler;

import me.humenius.fowler.prices.Price;

// RentalBuilder.java (bisa di file terpisah)
public class RentalBuilder {
    private String title;
    private Price price;
    private int daysRented;

    public RentalBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public RentalBuilder withPrice(Price price) {
        this.price = price;
        return this;
    }

    public RentalBuilder withDaysRented(int days) {
        this.daysRented = days;
        return this;
    }

    public Rental build() {
        Movie movie = new Movie(title, price);
        return new Rental(movie, daysRented);
    }
}

