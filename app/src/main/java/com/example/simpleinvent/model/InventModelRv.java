package com.example.simpleinvent.model;

public class InventModelRv {
    private String item_name;
    private String item_code;
    private int item_qty;
    private int item_price;


    public InventModelRv() {
    }

    public InventModelRv(String itemCode,String itemName, int itemPrice, int itemQty){
        this.item_code = itemCode;
        this.item_name = itemName;
        this.item_qty = itemQty;
        this.item_price = itemPrice;
    }


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
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
