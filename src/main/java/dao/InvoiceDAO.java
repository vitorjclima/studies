package dao;

import model.Invoice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InvoiceDAO {

    public List<Invoice> getOverdueInvoices() {

        //Next step will be implement: get the overdue invoices in a database.

        Invoice invoice1 = new Invoice("john@studies.com", BigDecimal.valueOf(350.10), LocalDate.now().minusDays(3));
        Invoice invoice2 = new Invoice("mary@studies.com", BigDecimal.valueOf(75.15), LocalDate.now().minusDays(15));
        Invoice invoice3 = new Invoice("katy@studies.com", BigDecimal.valueOf(182.50), LocalDate.now().minusMonths(1).minusDays(3));

        return Arrays.asList(invoice1, invoice2, invoice3);
    }

}
