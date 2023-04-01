package com.example.homebudget.domain.budgets;

import java.util.List;

// Interface that is used to get all budget types from BudgetType enum.
public interface BudgetTypeService {
    List<BudgetType> allBudgetTypes();
}
