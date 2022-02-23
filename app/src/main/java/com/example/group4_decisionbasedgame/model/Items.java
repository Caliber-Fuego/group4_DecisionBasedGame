package com.example.group4_decisionbasedgame.model;

public class Items {

    protected String name;
    protected int heal;
    protected static int quantity = 0;


    //Getters
    public String getName() {
        return name;
    }
    public int getHeal() {
        return heal;
    }
    public int getQuantity() {
        return quantity;
    }

    //Setters
    public void setHeal(int heal) {
        this.heal = heal;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        Items.quantity = quantity;
    }

}
