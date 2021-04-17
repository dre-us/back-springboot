package com.example.shop.request;

import com.example.shop.model.Product;

import java.util.ArrayList;

public class BuyRequest {

    private int buyer;
    private String address;
    private ArrayList<Product> products;

    public BuyRequest() {
    }

    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "buyRequest{" +
                "buyer=" + buyer +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}
