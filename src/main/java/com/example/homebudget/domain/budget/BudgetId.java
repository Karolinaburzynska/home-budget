package com.example.homebudget.domain.budget;

public record BudgetId(String value) {

    static BudgetId newId(String value) {
        return new BudgetId(value);
    }


}
