package com.gian.techstart.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Invoice {
    @Id
    private String id;
    private String customerAddress;
    private String customerName;
    private String distributorAddress;
    private String distributorName;
    private Date invoiceDate;
    private String invoiceNumber;
    private String manufacturerAddress;
    private String manufacturerName;
    private String productCode;
    private String productDescription;
    private Integer purchasedQty;
    private Double purchasedWeight;
    private Double totalPrice;
    private String unitOfMeasure;
    private Double unitPrice;
}
