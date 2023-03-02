package com.example.homebudget.api.budget.response;

import com.example.homebudget.domain.budget.Budget;
import com.example.homebudget.domain.budget.BudgetId;
import com.example.homebudget.domain.budget.BudgetType;

import java.math.BigDecimal;

public record BudgetResponseDto(
        String budgetId,
        String name,
        BigDecimal maxValue,
        BudgetType budgetType
)

{

    public static  BudgetResponseDto fromDomain(Budget budget){
        return new BudgetResponseDto(
                budget.budgetId().value(),
                budget.name(),
                budget.maxValue(),
                budget.budgetType()
        );
    }
}
