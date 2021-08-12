package com.twu.refactoring;

public class LineItem {
    private final String description;
    private final double price;
    private final int quantity;

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    double totalTax() {
        return totalAmount() * 0.10;
    }

    double totalPrice() {
        return totalAmount() + totalTax();
    }

    @Override
    public String toString() {
        return description + "\t" + price + "\t" + quantity + "\t" + totalAmount() + "\n";
    }
}