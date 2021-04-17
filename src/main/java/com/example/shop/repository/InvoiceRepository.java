package com.example.shop.repository;

import com.example.shop.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private final ArrayList<Invoice> invoices;

    public InvoiceRepository() {
        invoices = new ArrayList<>();
    }

    public void add(Invoice invoice) {
        invoices.add(invoice);
    }

    public void delete(int invoiceId) throws Exception{
        Invoice invoice = get(invoiceId);
        invoices.remove(invoice);
    }

    public Invoice get(int invoiceId) throws Exception {
        for (Invoice invoice : invoices) {
            if (invoice.getId() == invoiceId) {
                return invoice;
            }
        }
        throw new Exception("Invoice doesn't exist.");
    }

    public List<Invoice> getInvoices(int buyer) {
        ArrayList<Invoice> invoices_buyer = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (invoice.getBuyer() == buyer) {
                invoices_buyer.add(invoice);
            }
        }
        return List.copyOf(invoices_buyer);
    }

    public List<Invoice> getAll() {
        return List.copyOf(invoices);
    }

}
