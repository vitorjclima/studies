package scheduler;

import dao.InvoiceDAO;
import email.EmailSender;
import model.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Scheduler {

    private static Logger logger = LoggerFactory.getLogger(Invoice.class.getName());

    public static void debtorFilter(List<String> debtors, Predicate<String> condition) {
        debtors.stream().filter(condition::test)
                        .forEach(System.out::println);
    }

    public static void main(String[] args) {

        logger.info("Starting scheduler.");


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