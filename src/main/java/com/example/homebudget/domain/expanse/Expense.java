package com.example.homebudget.domain.expanse;

import com.example.homebudget.domain.budget.Budget;
import com.example.homebudget.domain.budget.BudgetId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document

public record Expense(
        @Id
        ExpenseId expenseId,
        BigDecimal amount,
        String title,
        LocalDateTime date,
        BudgetId budgetId

) {


}
