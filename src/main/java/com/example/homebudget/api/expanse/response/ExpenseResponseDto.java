package com.example.homebudget.api.expanse.response;

import com.example.homebudget.domain.budget.BudgetId;
import com.example.homebudget.domain.expanse.Expense;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpenseResponseDto(String expenseId,
                                 BigDecimal amount,
                                 String title,
                                 LocalDateTime date,
                                 BudgetId budgetId) {


    public static ExpenseResponseDto fromDomain(Expense expense) {
        return new ExpenseResponseDto(
                expense.expenseId().value(),
                expense.amount(),
                expense.title(),
                expense.date(),
                expense.budgetId()
        );
    }
}
