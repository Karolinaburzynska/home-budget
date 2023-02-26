package com.example.homebudget.domain;

import com.example.homebudget.infrastructure.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class DefaultExpensesService implements ExpenseService  {
    private final ExpensesRepository expensesRepository;
    private final Supplier<ExpenseId> expenseIdSupplier;


    public DefaultExpensesService(ExpensesRepository expensesRepository, Supplier<ExpenseId> expenseIdSupplier) {
        this.expensesRepository = expensesRepository;
        this.expenseIdSupplier = expenseIdSupplier;
    }

    @Override
    public Expense registerNewExpanse(String title, BigDecimal amount, LocalDateTime date) {
        Expense expense = new Expense(expenseIdSupplier.get(),  amount, title, date);
        expensesRepository.save(expense);
        return expense;
    }

    @Override
    public Optional<Expense> getExpanseById(ExpenseId expenseId) {
        return expensesRepository.getExpenseByExpenseId(expenseId);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expensesRepository.getAllExpenses();
    }

    @Override
    public void deleteExpenseById(ExpenseId expenseId) {
        expensesRepository.deleteExpenseById(expenseId);
    }

    @Override
    public void deleteAllExpenses() {
        expensesRepository.deleteAllExpenses();
    }

    @Override
    public Expense updateExpanse(ExpenseId expenseId, Expense expense) {
        return expensesRepository.updateExpanse(expenseId,expense);
    }

    @Override
    public Optional<Expense> updatePatchExpanse(ExpenseId expenseId, Optional<String> title, Optional<BigDecimal> amount, Optional<LocalDateTime> date) {
        return expensesRepository.getExpenseByExpenseId(expenseId)
                .map(oldExpanse ->
                        new Expense(expenseId,
                                amount.orElseGet(oldExpanse::amount),
                                title.orElseGet(oldExpanse::title),
                                date.orElseGet(oldExpanse::date)
                        )
                )
                .map(expensesRepository::save);
    }


}
