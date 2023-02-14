package com.example.homebudget;

import com.example.homebudget.domain.ExpensesRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryExpenseRepository implements ExpensesRepository {
    private final Map<String, Expense> expenseMap = new HashMap<String,Expense>();

    @Override
    public void saveExpense(Expense expense) {
        expenseMap.put(expense.getExpenseId(), expense);
    }

    @Override
    public List<Expense> getExpenses() {
        return expenseMap.values().stream().toList();
    }
}
