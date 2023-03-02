package com.example.homebudget.infrastructure.expanse;

import com.example.homebudget.domain.expanse.ExpenseId;
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
}
