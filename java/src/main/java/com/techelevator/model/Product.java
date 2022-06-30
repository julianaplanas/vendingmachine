package com.techelevator.model;

import java.math.BigDecimal;

public class Product {

    private String code;
    private String name;
    private BigDecimal price;
    private String category;
    private int quantity = 5;


    public Product(String id, String name, BigDecimal price, String category, int quantity)
    {
        this.code = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getCategory() {return category;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity -= quantity;
    }

    protected String quantityCheck() {
        if (quantity == 0) {
            return " - SOLD OUT";
        }
        return "";
    }


    @Override
    public String toString()
    {
        String line = String.format("%-5s %-25s $ %-7.2f %-15s", code, name, price, quantityCheck());
        return line;
        // return code + " - " + name + " - $" + price + quantityCheck();
    }


}
