package com.example.shop.request;

import com.example.shop.model.Product;

public class AddProductToInvoice {

    private int invoiceId;
    private Product product;

    public AddProductToInvoice() {
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "AddProductToInvoice{" +
                "invoiceId=" + invoiceId +
                ", product=" + product +
                '}';
    }
}
