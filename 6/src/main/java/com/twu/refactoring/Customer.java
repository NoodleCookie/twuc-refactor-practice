package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private final String name;
    private final ArrayList<Rental> rentalList = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentalList.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        double totalPrice = getTotalPrice(result);

        int frequentRenterPoints = (int) rentalList.stream().filter(rental -> rental.getMovie().getType() == MovieType.NEW_RELEASE && rental.getDaysRented() > 1).count() + rentalList.size();

        return result.append("Amount owed is ").append(totalPrice).append("\n").append("You earned ").append(frequentRenterPoints).append(" frequent renter points").toString();
    }

    private double getTotalPrice(StringBuilder result) {
        return rentalList.stream().mapToDouble(rental -> {
            MovieType type = rental.getMovie().getType();
            double price = type.getBasePricePerDay() + (rental.getDaysRented() > type.getIncrementDays() ? (rental.getDaysRented() - type.getIncrementDays()) * type.getIncrementPricePerDay() : 0);
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(price).append("\n");
            return price;
        }).sum();
    }

}
