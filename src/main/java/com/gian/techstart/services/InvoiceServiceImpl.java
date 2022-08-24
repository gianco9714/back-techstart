package com.gian.techstart.services;

import com.gian.techstart.model.Invoice;
import com.gian.techstart.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Invoice> getAllInvoices(String invoiceNumber, String distributorName, String customerName, String product) {
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();

        if (invoiceNumber != null && !invoiceNumber.isEmpty())
        criteria.add(Criteria.where("invoiceNumber").is(invoiceNumber));
        if (distributorName != null && !distributorName.isEmpty())
        criteria.add(Criteria.where("distributorName").is(distributorName));
        if (customerName != null && !customerName.isEmpty())
        criteria.add(Criteria.where("customerName").is(customerName));
        if (product != null && !product.isEmpty())
        criteria.add(Criteria.where("productDescription").is(product));
        if (!criteria.isEmpty())
        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        return mongoTemplate.find(query, Invoice.class);
    }
}
