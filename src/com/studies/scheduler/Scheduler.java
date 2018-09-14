package com.studies.scheduler;

import java.util.List;

import com.studies.dao.InvoiceDAO;
import com.studies.email.EmailSender;
import com.studies.model.Invoice;

public class Scheduler {

    public static void main(String[] args) {

        List<Invoice> overdueInvoices = new InvoiceDAO().getOverdueInvoices();
        EmailSender emailSender = new EmailSender();

        for (Invoice invoice : overdueInvoices) {
            emailSender.send(invoice.getDebtorEmail(), invoice.summary());
        }
    }
}
