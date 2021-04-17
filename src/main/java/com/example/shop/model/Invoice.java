package com.example.shop.model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {

    private int id;
    private Date date;
    private int buyer;
    private String address;
    private ArrayList<Product> products;
    private double subTotal;
    private double iva;
    private double shipping;
    private double total;
    private boolean canceled;

    public Invoice(int id, Date date, int buyer, String address,
                   ArrayList<Product> products, double subTotal,
                   double iva, double shipping, double total, boolean canceled) {
        this.id = id;
        this.date = date;
        this.buyer = buyer;
        this.address = address;
        this.products = products;
        this.subTotal = subTotal;
        this.iva = iva;
        this.shipping = shipping;
        this.total = total;
        this.canceled = canceled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", buyer=" + buyer +
                ", address='" + address + '\'' +
                ", products=" + products +
                ", subTotal=" + subTotal +
                ", iva=" + iva +
                ", shipping=" + shipping +
                ", total=" + total +
                ", canceled=" + canceled +
                '}';
    }
}
