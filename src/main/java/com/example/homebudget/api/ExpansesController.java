package com.example.homebudget.api;

import com.example.homebudget.api.request.PatchExpanseRequest;
import com.example.homebudget.api.response.ExpenseResponseDto;
import com.example.homebudget.domain.Expense;
import com.example.homebudget.domain.ExpenseId;
import com.example.homebudget.domain.ExpenseService;
import com.example.homebudget.api.request.RegisterExpenseRequest;
import com.example.homebudget.infrastructure.ExpensesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


import static com.example.homebudget.api.ExpansesController.EXPENSES_BASE_PATH;

@RestController
@RequestMapping(EXPENSES_BASE_PATH)
class ExpansesController {

    static final String EXPENSES_BASE_PATH = "/expenses";

    private final ExpenseService expenseService;

    private final ExpensesRepository expensesRepository;


    public ExpansesController(ExpenseService expenseService, ExpensesRepository expensesRepository) {
        this.expenseService = expenseService;
        this.expensesRepository = expensesRepository;
    }


    //displaying the created expense
    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDto> getSingleExpense( @PathVariable String expenseId) {
        Optional<Expense> expenseById = expenseService.getExpanseById(new ExpenseId(expenseId));
        return ResponseEntity.of(expenseById.map(ExpenseResponseDto::fromDomain));
    }


    //displaying all expenses
    @GetMapping()
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpanses() {
        return ResponseEntity.ok(expenseService.getAllExpenses().stream().map(ExpenseResponseDto::fromDomain).toList());
    }


    //expense saving
    @PostMapping
    public ResponseEntity<ExpenseResponseDto> registerNewExpanse(@RequestBody @Valid RegisterExpenseRequest request) {
        Expense newExpense = expenseService.registerNewExpanse(request.title(), request.amount(), request.date());
        ExpenseResponseDto expenseResponseDto = ExpenseResponseDto.fromDomain(newExpense);
        return ResponseEntity.created(URI.create("/expenses" + expenseResponseDto.expenseId())).body(expenseResponseDto);
    }

    //delete expense by id

    @DeleteMapping("/{deleteExpenseId}")
    public ResponseEntity<ExpenseResponseDto> deleteSingleExpense(@PathVariable("deleteExpenseId") ExpenseId deleteExpenseId) {
        expenseService.deleteExpenseById(deleteExpenseId);
        return ResponseEntity.noContent().build();

    }

    //delete all expenses
    @DeleteMapping()
    public ResponseEntity<ExpenseResponseDto> removeAllExpanses() {
        expenseService.deleteAllExpenses();
        return ResponseEntity.noContent().build();
    }

    //put expense
    @PutMapping("/{expenseId}")
    public ResponseEntity<Expense> updateExpanse(@PathVariable("expenseId") ExpenseId expenseId, @RequestBody RegisterExpenseRequest request) {
        Expense expense = new Expense(expenseId, request.amount(), request.title(), request.date());
        Expense updataExpense = expenseService.updateExpanse(expenseId, expense);
        return ResponseEntity.created(URI.create("/expenses")).body(updataExpense);
    }

    // partially update expense
    @PatchMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDto> partiallyUpdateExpense(@PathVariable("expenseId") ExpenseId expenseId, @Valid @RequestBody PatchExpanseRequest patchExpanseRequest) {
        return ResponseEntity.of(expenseService.updatePatchExpanse(expenseId, patchExpanseRequest.getTitle(), patchExpanseRequest.getAmount(), patchExpanseRequest.getDate())
                .map((ExpenseResponseDto::fromDomain)));
    }


}



