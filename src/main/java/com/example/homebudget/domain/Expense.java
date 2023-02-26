package com.example.homebudget.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record Expense(
     ExpenseId expenseId,
     BigDecimal amount,
     String title,
     LocalDateTime date
){


}
