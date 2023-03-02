package com.example.homebudget.domain.budget;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public record Budget(
        @Id
        BudgetId budgetId,
        String name,
        BigDecimal maxValue,
        BudgetType budgetType
) {



}
