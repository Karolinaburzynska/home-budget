package com.example.homebudget.api.expanse.request;

import com.example.homebudget.domain.budget.BudgetId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegisterExpenseRequest(
        @NotNull
        String title,
        @Positive
        BigDecimal amount,
        LocalDateTime date,
        String budgetId) {


    // record created to make object come from outside


}
