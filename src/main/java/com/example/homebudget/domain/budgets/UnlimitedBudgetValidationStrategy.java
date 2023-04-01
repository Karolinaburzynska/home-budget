package com.example.homebudget.domain.budgets;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UnlimitedBudgetValidationStrategy implements BudgetValidationStrategy{
    @Override
    public boolean supports(BudgetType budgetType) {
        return budgetType == BudgetType.UNLIMITED;
    }

    @Override
    public boolean validateBudgetInBounds(BigDecimal max, BigDecimal current, BigDecimal requested) {
        return true;
    }
}
