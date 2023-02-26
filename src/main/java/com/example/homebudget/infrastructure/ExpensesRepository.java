package com.example.homebudget.infrastructure;

import com.example.homebudget.api.request.RegisterExpenseRequest;
import com.example.homebudget.domain.Expense;
import com.example.homebudget.domain.ExpenseId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ExpensesRepository {

     Expense save(Expense expense);

     Optional<Expense> getExpenseByExpenseId(ExpenseId expenseId);

     List<Expense> getAllExpenses();

     void deleteExpenseById(ExpenseId expenseId);
     void deleteAllExpenses();

     Expense updateExpanse(ExpenseId expenseId, Expense expense);



}
