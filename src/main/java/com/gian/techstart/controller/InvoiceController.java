package com.gian.techstart.controller;

import com.gian.techstart.model.Invoice;
import com.gian.techstart.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoices( @RequestParam(required = false) String invoiceNumber,
                                                  @RequestParam(required = false) String distributorName,
                                                  @RequestParam(required = false) String customerName,
                                                  @RequestParam(required = false) String product) {
        return invoiceService.getAllInvoices(invoiceNumber,distributorName,customerName,product);
    }

}
