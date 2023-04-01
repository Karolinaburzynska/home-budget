package com.example.homebudget.domain.budgets;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class NormalBudgetValidationStrategy implements BudgetValidationStrategy{
    @Override
    public boolean supports(BudgetType budgetType) {
        return budgetType == BudgetType.NORMAL;
    }

    @Override
    public boolean validateBudgetInBounds(BigDecimal max, BigDecimal current, BigDecimal requested) {
        return max.compareTo(current.add(requested)) >= 0;
    }
}
