package com.gian.techstart;

import com.gian.techstart.model.Invoice;
import com.gian.techstart.services.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class InvoiceTest {

    private final List<Invoice> list = new ArrayList<>();
    private Invoice firstInvoice = new Invoice();
    private Invoice secondInvoice = new Invoice();

    @MockBean
    private InvoiceService service;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void setup(){
        firstInvoice.setId("630543fd10761d57d931a6eb");
        firstInvoice.setCustomerAddress("C Address A");
        firstInvoice.setCustomerName("Cust A");
        firstInvoice.setDistributorAddress("D Address A");
        firstInvoice.setDistributorName("Dist A");
        firstInvoice.setInvoiceDate(new Date());
        firstInvoice.setInvoiceNumber("1111");
        firstInvoice.setManufacturerAddress("M Address B");
        firstInvoice.setManufacturerName("Manuf B");
        firstInvoice.setProductCode("125");
        firstInvoice.setProductDescription("Eggs");
        firstInvoice.setPurchasedQty(10);
        firstInvoice.setPurchasedWeight(20.0);
        firstInvoice.setTotalPrice(50.0);
        firstInvoice.setUnitOfMeasure("CASE");
        firstInvoice.setUnitPrice(5.0);
        list.add(firstInvoice);

        secondInvoice.setId("630543fd10761d57d931a6f1");
        secondInvoice.setCustomerAddress("C Address A");
        secondInvoice.setCustomerName("Cust A");
        secondInvoice.setDistributorAddress("D Address c");
        secondInvoice.setDistributorName("Dist c");
        secondInvoice.setInvoiceDate(new Date());
        secondInvoice.setInvoiceNumber("1113");
        secondInvoice.setManufacturerAddress("M Address B");
        secondInvoice.setManufacturerName("Manuf B");
        secondInvoice.setProductCode("125");
        secondInvoice.setProductDescription("Mayonnaisse");
        secondInvoice.setPurchasedQty(7);
        secondInvoice.setPurchasedWeight(70.0);
        secondInvoice.setTotalPrice(70.0);
        secondInvoice.setUnitOfMeasure("CASE");
        secondInvoice.setUnitPrice(10.0);
        list.add(secondInvoice);

    }

    @Test
    public void userGetInvoices(){
        when(service.getAllInvoices(any(),any(),any(),any())).thenReturn(list);
        List<Invoice> listTest = service.getAllInvoices(any(),any(),any(),any());
        assertNotNull(listTest);
        assertEquals(2,listTest.size());
    }
}
