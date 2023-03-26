package com.example.homebudget.domain.budgets;

public enum BudgetType {
    NORMAL("Budget will not allow to add expenses when overfilled "),
    UNLIMITED("Budget will allow you to add expenses in case of overflow"),
    DOUBLE("Budget  will allow you to add expenses exceeding 2x");


    private final String description;

    BudgetType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
