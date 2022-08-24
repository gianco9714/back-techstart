package com.gian.techstart.services;

import com.gian.techstart.model.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices(String invoiceNumber,String distributorName,String customerName,String product);

}
