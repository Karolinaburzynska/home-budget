package com.example.homebudget.domain.expanse;

import com.example.homebudget.domain.budget.BudgetId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BudgetNotFoundException extends IllegalStateException {

    private final BudgetId budgetId;

    public BudgetNotFoundException(BudgetId budgetId) {
        this.budgetId = budgetId;
    }

    @Override
    public String getMessage() {
        return ("not found budgetId" + budgetId);
    }
}
