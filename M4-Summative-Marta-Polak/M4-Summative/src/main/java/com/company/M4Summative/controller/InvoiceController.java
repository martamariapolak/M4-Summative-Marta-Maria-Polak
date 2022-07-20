package com.company.M4Summative.controller;

import com.company.M4Summative.model.Invoice;
import com.company.M4Summative.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/invoice")
@CrossOrigin(origins = {"https://localhost:3000"})

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping()
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/invoice/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (!invoice.isPresent()) {
            return null;
        }
        return invoice.get();
    }

    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @PutMapping("/invoice")
    public void updateInvoice(@RequestBody Invoice invoice, @PathVariable int id) {
        invoiceRepository.save(invoice);
    }

    @DeleteMapping("/invoices/{id}")
    public void deleteInvoice(@PathVariable int id) {
        invoiceRepository.deleteById(id);
    }

    /*
     @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@Valid @RequestBody Invoice invoice) {
        if (taxServiceLayer.findSalesTaxRateByState(invoice.getState()) == null) {
            throw new QueryNotFoundException(invoice.getState() + " is not a valid state code");
        }
        if (invoice.getQuantity() <= 0) {
            throw new IllegalArgumentException("You must purchase at least 1 item");
        }
        if (invoice.getQuantity() > serviceLayer.getItemQuantity(invoice)) {
            throw new NotEnoughInStockException("You cannot buy that many.  There are currently only " + serviceLayer.getItemQuantity(invoice) + " units avaiable.");
        }
        return serviceLayer.addInvoice(invoice);
    }
     */
}