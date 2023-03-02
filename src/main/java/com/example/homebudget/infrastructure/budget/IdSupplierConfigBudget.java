package com.example.homebudget.infrastructure.budget;

import com.example.homebudget.domain.budget.BudgetId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.function.Supplier;

@Configuration
public class IdSupplierConfigBudget {
    @Bean
    public Supplier<BudgetId> budgetIdSupplier() {
        return () -> new BudgetId(UUID.randomUUID().toString());
    }

}
