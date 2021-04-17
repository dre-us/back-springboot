package com.example.shop.controller;

import com.example.shop.model.Invoice;
import com.example.shop.request.AddProductToInvoice;
import com.example.shop.request.BuyRequest;
import com.example.shop.request.DeleteInvoiceRequest;
import com.example.shop.request.EditInvoiceRequest;
import com.example.shop.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "api/invoice")
public class InvoiceController {

    final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public void buy(@RequestBody BuyRequest buyRequest) {
        try {
            invoiceService.generateInvoice(buyRequest.getBuyer(), buyRequest.getAddress(), buyRequest.getProducts());
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }

    }

    @PutMapping
    public void edit(@RequestBody EditInvoiceRequest editInvoiceRequestRequest) {
        try {
            invoiceService.editInvoice(editInvoiceRequestRequest.getInvoiceId(), editInvoiceRequestRequest.getProducts());
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @PutMapping(value = "/add")
    public void add(@RequestBody AddProductToInvoice addProductToInvoice) {
        try {
            invoiceService.addProduct(addProductToInvoice.getInvoiceId(), addProductToInvoice.getProduct());
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteInvoiceRequest deleteInvoiceRequest) {
        try {
            invoiceService.deleteInvoice(deleteInvoiceRequest.getInvoiceId());
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @GetMapping
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    @GetMapping(value = "/{id_buyer}")
    public List<Invoice> getInvoices(@PathVariable("id_buyer") int buyer) {
        return invoiceService.getInvoices(buyer);
    }
}
