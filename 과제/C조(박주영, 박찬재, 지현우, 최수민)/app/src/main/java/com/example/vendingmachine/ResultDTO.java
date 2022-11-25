package com.example.vendingmachine;

import java.io.Serializable;

public class ResultDTO implements Serializable {
    private int qty,price;
    private String name;

    public ResultDTO( int qty, int price, String name) {

        this.qty = qty;
        this.price = price;
        this.name = name;
    }



    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
