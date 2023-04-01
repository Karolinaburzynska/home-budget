package com.example.homebudget.domain.budgets;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBudgetTypeService implements  BudgetTypeService{

    @Override
    public List<BudgetType> allBudgetTypes() {
        return List.of(BudgetType.values());
    }
}
