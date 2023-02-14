package com.example.homebudget.domain;

import com.example.homebudget.Expense;

import java.util.List;

public interface ExpensesRepository {
     void saveExpense(Expense expense);
     List<Expense> getExpenses();
}
