package com.example.homebudget.infrastructure;

import com.example.homebudget.domain.budgets.BudgetId;
import com.example.homebudget.domain.expanses.ExpenseId;
import com.example.homebudget.domain.users.UserId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.UUID;
import java.util.function.Supplier;

@Configuration
public class IdSupplierConfig {
    @Bean
    public Supplier<ExpenseId> expenseIdSupplier() {
        return () -> new ExpenseId(UUID.randomUUID().toString());
    }

    @Bean
    public Supplier<UserId> userIdSupplier() {
        return () -> new UserId(UUID.randomUUID().toString());
    }
    @Bean
    public Supplier<BudgetId> budgetIdSupplier() {
        return () -> new BudgetId(UUID.randomUUID().toString());
    }

}
