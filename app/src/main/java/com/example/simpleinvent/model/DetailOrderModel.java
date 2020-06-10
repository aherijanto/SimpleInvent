package com.example.simpleinvent.model;

public class DetailOrderModel {
    private String item_code;
    private String item_name;
    private int item_qty;
    private int item_price;

    public DetailOrderModel() {
    }

    public DetailOrderModel(String item_code, String item_name, int item_qty, int item_price) {
        this.item_code = item_code;
        this.item_name = item_name;
        this.item_qty = item_qty;
        this.item_price = item_price;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(int item_qty) {
        this.item_qty = item_qty;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }
}
