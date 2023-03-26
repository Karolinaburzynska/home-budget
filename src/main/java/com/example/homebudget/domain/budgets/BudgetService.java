package com.example.homebudget.domain.budgets;

import com.example.homebudget.domain.users.UserId;

import java.math.BigDecimal;
import java.util.Optional;

public interface BudgetService {

    Budget registerNewBudget(String name, UserId userId, BigDecimal maxValue, BudgetType budgetType);

    Optional<Budget> findBudgetById(BudgetId budgetId);
    Optional<BudgetDetails> findBudgetDetailsById(BudgetId budgetId);

    BigDecimal sumExpensesInBudget(BudgetId budgetId);

    BigDecimal percentBudget(BigDecimal maxValue, BudgetId budgetId);

}
