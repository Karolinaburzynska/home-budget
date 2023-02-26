package com.example.homebudget.api.response;

import com.example.homebudget.domain.Expense;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseResponseDto(String expenseId,
                                 BigDecimal amount,
                                 String title,
                                 LocalDateTime date) {


    public static ExpenseResponseDto fromDomain(Expense expense) {
        return new ExpenseResponseDto(
                expense.expenseId().value(),
                expense.amount(),
                expense.title(),
                expense.date()
        );
    }
}
