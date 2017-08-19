package com.example.pushpika.mobileresturant;


public class HorizontalAlbum {
    private String name;
    private float price;
    private int quantity;
    private boolean isOrdered;
    private int thumbnail;

    public HorizontalAlbum() {
    }

    public HorizontalAlbum(String name, float price, int quantity,boolean isOrdered, int thumbnail) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isOrdered =isOrdered;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(boolean isOrdered) {
        this.isOrdered = isOrdered;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
