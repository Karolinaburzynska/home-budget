package com.example.homebudget.domain.budget;

import com.example.homebudget.infrastructure.budget.BudgetRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class DefaultBudgetService implements BudgetService{
    public final BudgetRepository budgetRepository;
    private final Supplier<BudgetId> budgetIdSupplier;

    public DefaultBudgetService(BudgetRepository budgetRepository, Supplier<BudgetId> budgetIdSupplier) {
        this.budgetRepository = budgetRepository;
        this.budgetIdSupplier = budgetIdSupplier;
    }

    @Override
    public Budget registerNewBudget(String name, BigDecimal maxValue, BudgetType budgetType) {
      Budget budget = new Budget(budgetIdSupplier.get(), name, maxValue, budgetType);
      budgetRepository.save(budget);
      return budget;
    }

    @Override
    public Optional<Budget> findBudgetById(BudgetId budgetId) {
        return budgetRepository.findBudgetByBudgetId(budgetId);
    }
}
