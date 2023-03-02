package com.example.homebudget.infrastructure.expanse;

import com.example.homebudget.domain.expanse.Expense;
import com.example.homebudget.domain.expanse.ExpenseId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpensesRepository extends MongoRepository<Expense, ExpenseId> {


    Optional<Expense> findExpenseByExpenseId(ExpenseId expenseId);


}
