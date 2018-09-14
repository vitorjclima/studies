package com.studies.scheduler;

import java.util.List;

import com.studies.dao.InvoiceDAO;
import com.studies.email.EmailSender;
import com.studies.model.Invoice;

public class Scheduler {

    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();

        List<Invoice> overdueInvoices = new InvoiceDAO().getOverdueInvoices();
        overdueInvoices.forEach(invoice -> {
            emailSender.send(invoice.getDebtorEmail(), invoice.summary());
            invoice.setSentNotification(true);
        });
    }
}
