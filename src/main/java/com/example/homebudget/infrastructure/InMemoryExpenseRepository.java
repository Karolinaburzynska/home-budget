package com.example.homebudget.infrastructure;

import com.example.homebudget.domain.Expense;
import com.example.homebudget.domain.ExpenseId;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryExpenseRepository implements ExpensesRepository {
    private final Map<ExpenseId, Expense> expenseMap = new HashMap<ExpenseId, Expense>();


    // save expanse
    @Override
    public Expense save(Expense expense) {
        return expenseMap.put(expense.expenseId(), expense);
    }


    // metoda do pobierania wydatku po id
    @Override
    public Optional<Expense> getExpenseByExpenseId(ExpenseId expenseId) {
        return Optional.ofNullable(expenseMap.get(expenseId));
    }


    //metoda do pobierania wszystkich wydatków
    @Override
    public List<Expense> getAllExpenses() {
        return expenseMap.values().stream().toList();

    }

    @Override
    public void deleteExpenseById(ExpenseId expenseId) {
         expenseMap.remove(expenseId);
    }

    @Override
    public void deleteAllExpenses() {
        expenseMap.clear();

    }

    @Override
    public Expense updateExpanse(ExpenseId expenseId, Expense expense ) {
        expenseMap.replace(expenseId,expense);
        return expenseMap.get(expenseId);
    }




}
