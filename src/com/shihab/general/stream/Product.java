package com.shihab.general.stream;

public class Product {
    private String item;
    private int price;
    private int available;
    private int discount;
    private String category;
    private String barcode;

    // Getters and Setters
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getAvailable() { return available; }
    public void setAvailable(int available) { this.available = available; }

    public int getDiscount() { return discount; }
    public void setDiscount(int discount) { this.discount = discount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
}
