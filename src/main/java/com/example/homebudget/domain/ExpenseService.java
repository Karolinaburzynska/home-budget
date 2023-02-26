package com.example.homebudget.domain;

import com.example.homebudget.api.request.PatchExpanseRequest;
import com.example.homebudget.api.request.RegisterExpenseRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ExpenseService {

    Expense registerNewExpanse(String title, BigDecimal amount, LocalDateTime date);
    Optional <Expense> getExpanseById(ExpenseId expenseId);

    List<Expense> getAllExpenses();

    void deleteExpenseById(ExpenseId expenseId);

    void deleteAllExpenses();

    Expense updateExpanse(ExpenseId expenseId, Expense expense);

    Optional<Expense> updatePatchExpanse(ExpenseId expenseId, Optional<String> title, Optional<BigDecimal> amount, Optional<LocalDateTime> date);

}
