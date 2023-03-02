package com.example.homebudget.api.expanse.request;

import com.example.homebudget.domain.budget.BudgetId;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class PatchExpanseRequest {
    private final String title;
    private final BigDecimal amount;
    private final LocalDateTime date;
    @AssertTrue(message = "At least one field is required")
    private final boolean fieldsExists;
    private final BudgetId budgetId;

    public PatchExpanseRequest(String title, BigDecimal amount, LocalDateTime date, boolean fieldsExists, BudgetId budgetId) {
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.fieldsExists = title != null || amount != null || date != null;
        this.budgetId = budgetId;
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    public Optional<BigDecimal> getAmount() {
        return Optional.ofNullable(amount);
    }

    public Optional<LocalDateTime> getDate() {
        return Optional.ofNullable(date);
    }

    public Optional<BudgetId> getBudgetId() {
        return Optional.ofNullable(budgetId);
    }
}
