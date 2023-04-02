package com.example.homebudget.infrastructure.expanse;

import com.example.homebudget.domain.budgets.BudgetId;
import com.example.homebudget.domain.expanses.Expense;
import com.example.homebudget.domain.expanses.ExpenseId;
import com.example.homebudget.domain.users.UserId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpensesRepository extends MongoRepository<Expense, ExpenseId> {


    Optional<Expense> findExpenseByExpenseIdAndUserId(ExpenseId expenseId, UserId userId);
    Page<Expense> findExpensesByUserId(UserId userId, Pageable pageable);
    List<Expense> findExpensesByUserIdAndBudgetId(UserId userId, BudgetId budgetId);

}
