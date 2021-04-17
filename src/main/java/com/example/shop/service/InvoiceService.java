package com.example.shop.service;

import com.example.shop.model.Invoice;
import com.example.shop.model.Product;
import com.example.shop.repository.InvoiceRepository;
import com.example.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {

    private static int id = 1;
    private final InvoiceRepository invoiceRepository;
    public static final double IVA = 0.19;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void generateInvoice(int buyer, String address, ArrayList<Product> products) throws Exception{
        Date date = new Date();
        double subTotal = calculateCost(products);
        if (subTotal < 70000) {
            //what happens if billing is lower than 70000?
            return;
        }
        double iva = subTotal * IVA;
        double shippingCost = calculateShippingCost();
        double total = subTotal + iva;
        if (subTotal <= 100000) total += shippingCost;
        invoiceRepository.add(new Invoice(id, date, buyer, address, products, subTotal, iva, shippingCost, total, false));
        id += 1;
    }

    private double calculateCost(ArrayList<Product> products) throws Exception{
        int total = 0;
        for (Product product : products)
            total += product.getCost();
        return total;
    }

    private double calculateShippingCost() {
        //here code to calculate shipping cost
        return 5000;
    }

    public void addProduct(int invoiceId, Product product) throws Exception{
        Invoice invoice = invoiceRepository.get(invoiceId);
        if (invoice.isCanceled()) return;
        double productCost = product.getCost();
        double prevSubTotal = invoice.getSubTotal();
        double newSubTotal = prevSubTotal + productCost;
        double newIva = newSubTotal * IVA;
        double newShippingCost = invoice.getShipping();
        if (newSubTotal > 100000)
            newShippingCost = 0;
        invoice.setSubTotal(newSubTotal);
        invoice.setIva(newIva);
        invoice.setShipping(newShippingCost);
        invoice.getProducts().add(product);
        invoice.setTotal(newSubTotal + newIva + newShippingCost);
    }

    public void editInvoice(int id, ArrayList<Product> products) throws Exception{
        Invoice invoice = invoiceRepository.get(id);
        if (invoice.isCanceled()) return;
        Date dateNow = new Date();
        long timeElapsed = dateNow.getTime() - invoice.getDate().getTime();
        long hoursElapsed = timeElapsed/1000/60/60;
        double newSubTotal = calculateCost(products);
        if (hoursElapsed <= 5 && invoice.getSubTotal() <= newSubTotal) {
            double newIva = newSubTotal*IVA;
            double newShippingCost = invoice.getShipping();
            if (newSubTotal > 100000)
                newShippingCost = 0;
            invoice.setSubTotal(newSubTotal);
            invoice.setIva(newIva);
            invoice.setShipping(newShippingCost);
            invoice.setProducts(products);
            invoice.setTotal(newSubTotal + newIva + newShippingCost);
        } else {
            throw new Exception("The cost of products must be greater than or equal to previous ones");
        }
    }

    public void deleteInvoice(int id) throws Exception{
        Invoice invoice = invoiceRepository.get(id);
        if (invoice.isCanceled()) return;
        Date dateNow = new Date();
        long timeElapsed = dateNow.getTime() - invoice.getDate().getTime();
        long hoursElapsed = timeElapsed/1000/60/60;
        if (hoursElapsed <= 12) {
            invoiceRepository.delete(id);
        } else {
            invoice.setCanceled(true);
            double nextSubTotal = invoice.getSubTotal() * 0.10;
            invoice.setSubTotal(nextSubTotal);
            invoice.setIva(0);
            invoice.setShipping(0);
            invoice.setTotal(nextSubTotal);
        }
    }

    public List<Invoice> getInvoices(int buyer) {
        return invoiceRepository.getInvoices(buyer);
    }

    public List<Invoice> getInvoices() {
        return invoiceRepository.getAll();
    }
}
