package com.example.shop.request;

import com.example.shop.model.Product;

import java.util.ArrayList;

public class EditInvoiceRequest {

    private int invoiceId;
    private ArrayList<Product> products;

    public EditInvoiceRequest() {
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "EditInvoiceRequest{" +
                "invoiceId=" + invoiceId +
                ", products=" + products +
                '}';
    }
}
