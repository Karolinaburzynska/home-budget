package com.example.homebudget.domain.expanse;

import com.example.homebudget.domain.budget.BudgetId;
import com.example.homebudget.infrastructure.budget.BudgetRepository;
import com.example.homebudget.infrastructure.expanse.ExpensesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.module.FindException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;


@Service
public class DefaultExpensesService implements ExpenseService {
    private final ExpensesRepository expensesRepository;
    private final Supplier<ExpenseId> expenseIdSupplier;
    private final BudgetRepository budgetRepository;
    private static final Logger logger = LoggerFactory.getLogger(DefaultExpensesService.class);


    public DefaultExpensesService(ExpensesRepository expensesRepository, Supplier<ExpenseId> expenseIdSupplier, BudgetRepository budgetRepository) {
        this.expensesRepository = expensesRepository;
        this.expenseIdSupplier = expenseIdSupplier;
        this.budgetRepository = budgetRepository;
    }

    @Override
    public Expense registerNewExpanse(String title, BigDecimal amount, LocalDateTime date, BudgetId budgetId) {
        Expense expense = new Expense(expenseIdSupplier.get(), amount, title, date, budgetId);
        if (existId(budgetId)) {
            expensesRepository.save(expense);
        } else {
            logger.warn("expense not found budgetId {}",budgetId);
            throw new BudgetNotFoundException(budgetId);
        }
        return expense;
    }



    @Override
    public Optional<Expense> findExpenseByExpenseId(ExpenseId expenseId) {
        return expensesRepository.findExpenseByExpenseId(expenseId);
    }

    @Override
    public List<Expense> findAll() {
        return expensesRepository.findAll();
    }

    @Override
    public void deleteExpenseById(ExpenseId expenseId) {
        expensesRepository.deleteById(expenseId);
    }

    @Override
    public void deleteAllExpenses() {
        expensesRepository.deleteAll();
    }

    @Override
    public Expense updateExpanse(Expense expense) {
        return expensesRepository.save(expense);
    }


    @Override
    public Optional<Expense> updatePatchExpanse(ExpenseId expenseId, Optional<String> title, Optional<BigDecimal> amount, Optional<LocalDateTime> date, Optional<BudgetId> budgetId) {
        return expensesRepository.findExpenseByExpenseId(expenseId)
                .map(oldExpanse ->
                        new Expense(expenseId,
                                amount.orElseGet(oldExpanse::amount),
                                title.orElseGet(oldExpanse::title),
                                date.orElseGet(oldExpanse::date),
                                budgetId.orElseGet(oldExpanse::budgetId)

                        )
                )
                .map(expensesRepository::save);
    }

    //sprawdza czy budgetId istnieje w bazie
    @Override
    public boolean existId(BudgetId budgetId) {
        return budgetRepository.existsById(budgetId);

    }

    @Override
    public Page<Expense> getExpensePage() {
        return expensesRepository.findAll(PageRequest.ofSize(3));
    }
}



