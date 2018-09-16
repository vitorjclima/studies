package com.studies.scheduler;

import java.util.List;

import com.studies.dao.InvoiceDAO;
import com.studies.email.EmailSender;
import com.studies.model.Invoice;

public class Scheduler {

    public static void main(String[] args) {

        List<Invoice> overdueInvoices = new InvoiceDAO().getOverdueInvoices();
        overdueInvoices.forEach(invoice -> {

            EmailSender emailSender = (to, text) -> System.out.println("Sending e-mail to " + to + " with the text: "+ text +".\n");
            emailSender.send(invoice.getDebtorEmail(), invoice.summary());

            invoice.setSentNotification(true);
        });
    }
}