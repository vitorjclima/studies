package com.studies.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.studies.dao.InvoiceDAO;
import com.studies.email.EmailSender;
import com.studies.model.Invoice;

public class Scheduler {

    public static void debtorFilter(List<String> debtors, Predicate<String> condition) {
        debtors.stream().filter(condition::test)
                        .forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<Invoice> overdueInvoices = new InvoiceDAO().getOverdueInvoices();
        overdueInvoices.forEach(invoice -> {

            EmailSender emailSender = (to, text) -> System.out.println("Sending e-mail to " + to + " with the text: "+ text +".\n");
            emailSender.send(invoice.getDebtorEmail(), invoice.summary());

            invoice.setSentNotification(true);
        });

        List<String> debtors = new ArrayList<>();
        overdueInvoices.forEach(x -> debtors.add(x.getDebtorEmail()));

        //Method reference
        debtors.forEach(System.out::println);

        //Predicate
        debtorFilter(debtors, s -> s.startsWith("m"));
    }
}