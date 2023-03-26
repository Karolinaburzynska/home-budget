package com.example.homebudget.domain.budgets;

import com.example.homebudget.domain.expanses.Expense;
import com.example.homebudget.domain.users.UserId;
import com.example.homebudget.infrastructure.budget.BudgetRepository;
import com.example.homebudget.infrastructure.expanse.ExpensesRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class DefaultBudgetService implements BudgetService{
    private final BudgetRepository budgetRepository;
    private final ExpensesRepository expensesRepository;
    private final Supplier<BudgetId> budgetIdSupplier;

    public DefaultBudgetService(BudgetRepository budgetRepository, ExpensesRepository expensesRepository, Supplier<BudgetId> budgetIdSupplier) {
        this.budgetRepository = budgetRepository;
        this.expensesRepository = expensesRepository;
        this.budgetIdSupplier = budgetIdSupplier;
    }

    @Override
    public Budget registerNewBudget(String name, UserId userId, BigDecimal maxValue, BudgetType budgetType) {
      Budget budget = new Budget(budgetIdSupplier.get(), userId, name, maxValue, budgetType);
      budgetRepository.save(budget);
      return budget;
    }

    @Override
    public Optional<Budget> findBudgetById(BudgetId budgetId) {
        return budgetRepository.findBudgetByBudgetId(budgetId);
    }

    @Override
    public Optional<BudgetDetails> findBudgetDetailsById(BudgetId budgetId) {
        sumExpensesInBudget(budgetId);
        return budgetRepository.findBudgetDetailsByBudgetId(budgetId);
    }

    @Override
    public BigDecimal sumExpensesInBudget(BudgetId budgetId) {
        List<Expense> expenseByBudgetId = expensesRepository.findExpenseByBudgetId(budgetId);
        return expenseByBudgetId.stream().map(expense -> expense.amount()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal percentBudget(BigDecimal maxValue, BudgetId budgetId) {
     return sumExpensesInBudget(budgetId).divide(maxValue);
    }


}
