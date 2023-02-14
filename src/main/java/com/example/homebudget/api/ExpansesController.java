package com.example.homebudget.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping
public class ExpansesController {
    @GetMapping("/expenses")
    public ResponseEntity<Expense> getAllExpense(){
        return ResponseEntity.ok(new Expense(UUID.randomUUID().toString(), BigDecimal.valueOf(12.22), "zakupy", LocalDateTime.now()));
    }


}
