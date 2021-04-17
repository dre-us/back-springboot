package com.example.shop.request;

public class DeleteInvoiceRequest {

    private int invoiceId;

    public DeleteInvoiceRequest() {
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String toString() {
        return "DeleteInvoiceRequest{" +
                "invoiceId=" + invoiceId +
                '}';
    }
}
