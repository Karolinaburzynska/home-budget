package com.example.homebudget.domain.budgets;

import java.math.BigDecimal;

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
