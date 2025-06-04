package me.humenius.fowler;

public class StatementBuilder {
    private final Customer customer;

    public StatementBuilder(Customer customer) {
        this.customer = customer;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rental Record for ").append(customer.getName()).append("\n");
        for (Rental rental : customer.getRentals()) {
            sb.append("\t").append(rental.getTitle())
              .append("\t").append(rental.getDaysRented())
              .append("\t").append(rental.getCharge()).append("\n");
        }
        sb.append("Amount owed is ").append(customer.getTotalCharge()).append("\n");
        sb.append("You earned ").append(customer.getTotalFrequentRenterPoints())
          .append(" frequent renter points");
        return sb.toString();
    }
}

