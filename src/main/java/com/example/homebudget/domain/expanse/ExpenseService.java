package com.example.homebudget.domain.expanse;

import com.example.homebudget.domain.budget.BudgetId;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ExpenseService {

    Expense registerNewExpanse(String title, BigDecimal amount, LocalDateTime date, BudgetId budgetId);

    Optional<Expense> findExpenseByExpenseId(ExpenseId expenseId);

    List<Expense> findAll();

    void deleteExpenseById(ExpenseId expenseId);

    void deleteAllExpenses();

    Expense updateExpanse(Expense expense);


    Optional<Expense> updatePatchExpanse(ExpenseId expenseId, Optional<String> title, Optional<BigDecimal> amount, Optional<LocalDateTime> date, Optional<BudgetId> budgetId);

    boolean existId (BudgetId budgetId);

    Page<Expense> getExpensePage();
}
