package com.twu.refactoring;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final String name;
    private final String address;
    private final List<LineItem> lineItems;

    public Order(String name, String address, List<LineItem> lineItems) {
        this.name = name;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String printLineList(){
        return lineItems.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public double totalPrice(){
        return lineItems.stream().mapToDouble(LineItem::totalPrice).sum();
    }

    public double totalAmount(){
        return lineItems.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    public double totalTax(){
        return lineItems.stream().mapToDouble(LineItem::totalTax).sum();
    }
}
