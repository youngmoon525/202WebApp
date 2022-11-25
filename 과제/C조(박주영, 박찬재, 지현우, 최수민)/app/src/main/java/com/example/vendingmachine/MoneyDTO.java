package com.example.vendingmachine;

import java.io.Serializable;

public class MoneyDTO implements Serializable {
    private int money;

    public MoneyDTO(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
