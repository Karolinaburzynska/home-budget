package com.example.homebudget.api.request;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class PatchExpanseRequest {
    private final String title;
    private final BigDecimal amount;
    private final LocalDateTime date;
    @AssertTrue(message = "At least one field is required")
    private final boolean fieldsExists;

    public PatchExpanseRequest(String title, BigDecimal amount, LocalDateTime date, boolean fieldsExists) {
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.fieldsExists = title != null || amount != null || date != null;
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    public Optional<BigDecimal> getAmount() {
        return Optional.ofNullable(amount);
    }

    public Optional<LocalDateTime> getDate() {
        return Optional.ofNullable(date);
    }
}
