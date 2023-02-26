package com.example.homebudget.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Expense {
   private final String expenseId;
  private final BigDecimal amount;
  private final String title;
  private final LocalDateTime date;

    public Expense(String expenseId, BigDecimal amount, String title, LocalDateTime date) {

        this.expenseId = expenseId;
        this.amount = amount;
        this.title = title;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return expenseId.equals(expense.expenseId) && amount.equals(expense.amount) && title.equals(expense.title) && date.equals(expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, amount, title, date);
    }

    public String getExpenseId() {
        return expenseId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
