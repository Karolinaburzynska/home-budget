package com.example.homebudget.api.budget.request;

import com.example.homebudget.domain.budget.BudgetType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public record RegisterBudgetRequest(
        @NotNull
        String name,
        @Positive
        BigDecimal maxValue,
        BudgetType budgetType) {

}
