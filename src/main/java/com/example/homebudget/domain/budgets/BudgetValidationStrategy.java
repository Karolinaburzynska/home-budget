package com.example.homebudget.domain.budgets;

import java.math.BigDecimal;

public interface BudgetValidationStrategy {

    boolean supports(BudgetType budgetType);
    boolean validateBudgetInBounds(BigDecimal max, BigDecimal current, BigDecimal requested);

}
