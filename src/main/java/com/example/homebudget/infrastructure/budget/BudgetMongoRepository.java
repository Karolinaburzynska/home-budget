package com.example.homebudget.infrastructure.budget;

import com.example.homebudget.domain.budget.Budget;
import com.example.homebudget.domain.budget.BudgetId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetMongoRepository extends MongoRepository<Budget, BudgetId> {
}
