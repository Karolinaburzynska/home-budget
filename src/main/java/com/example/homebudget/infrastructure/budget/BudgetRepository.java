package com.example.homebudget.infrastructure.budget;

import com.example.homebudget.domain.budget.Budget;
import com.example.homebudget.domain.budget.BudgetId;
import com.example.homebudget.domain.expanse.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, BudgetId> {
    Optional<Budget> findBudgetByBudgetId(BudgetId budgetId);

}
