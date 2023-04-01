package com.example.zoologico.controllers;

import com.example.zoologico.Zoologico;
import com.example.zoologico.models.SalesInvoice;

import java.util.ArrayList;

public class PdfCalculoController {
    public ArrayList<String> getInvoiceList() {
        ArrayList<String> newInvoiceList = new ArrayList<String>();
        for (SalesInvoice salesInvoice : Zoologico.invoiceList) {
            newInvoiceList.add(salesInvoice.getPlan().getName());
            newInvoiceList.add(String.valueOf(salesInvoice.getPlan().getQuantity()));
            newInvoiceList.add(String.valueOf(salesInvoice.getPlan().getPrice()));
            newInvoiceList.add(String.valueOf(salesInvoice.getTotalDiscount()));
        }
        return newInvoiceList;
    }
}

