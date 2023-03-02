package com.example.homebudget.infrastructure.expanse;

import com.example.homebudget.domain.expanse.Expense;
import com.example.homebudget.domain.expanse.ExpenseId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ExpanseMongoRepository extends MongoRepository< Expense, ExpenseId> {
  //  Optional<Expense> findByAmountBetween (BigDecimal min, BigDecimal max);
}
