package com.example.homebudget.domain.budget;

import com.example.homebudget.domain.expanse.Expense;
import com.example.homebudget.domain.expanse.ExpenseId;

import java.math.BigDecimal;
import java.util.Optional;

public interface BudgetService {

    Budget registerNewBudget (String name, BigDecimal maxValue, BudgetType budgetType);
    Optional<Budget> findBudgetById(BudgetId budgetId);

}
