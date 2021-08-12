package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private String name;
    private ArrayList<Rental> rentalList = new ArrayList<Rental>();

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

        double totalPrice = rentalList.stream().mapToDouble(rental -> {
            MovieType type = rental.getMovie().getType();
            double price = type.getBasePricePerDay() + (rental.getDaysRented() > type.getIncrementDays() ? (rental.getDaysRented() - type.getIncrementDays()) * type.getIncrementPricePerDay() : 0);
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(String.valueOf(price)).append("\n");
            return price;
        }).sum();

        int frequentRenterPoints = 0;

        for (Rental rental : rentalList) {
            double thisAmount = 0;
            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) {
                thisAmount += rental.getDaysRented() * 3;
                if (rental.getDaysRented() > 1) {
                    frequentRenterPoints++;
                }
            }
            frequentRenterPoints++;
        }
        return result.append("Amount owed is ").append(String.valueOf(totalPrice)).append("\n").append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points").toString();
    }

}
