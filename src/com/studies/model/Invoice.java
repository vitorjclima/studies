package com.studies.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Invoice {

    private String debtorEmail;
    private BigDecimal amount;
    private LocalDate dueDate;

    public Invoice(String debtorEmail, BigDecimal amount, LocalDate dueDate) {
        this.debtorEmail = debtorEmail;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public String getDebtorEmail() {
        return debtorEmail;
    }

    public void setDebtorEmail(String debtorEmail) {
        this.debtorEmail = debtorEmail;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String summary() {
        String formattedDueDate = getDueDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("Due Amount: €%s, Due Date: %s", getAmount(), formattedDueDate);
    }
}
