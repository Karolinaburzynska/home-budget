package com.example.homebudget.api.expanse;

import com.example.homebudget.api.expanse.request.PatchExpanseRequest;
import com.example.homebudget.api.expanse.response.ExpenseResponseDto;
import com.example.homebudget.domain.budget.BudgetId;
import com.example.homebudget.domain.expanse.Expense;
import com.example.homebudget.domain.expanse.ExpenseId;
import com.example.homebudget.domain.expanse.ExpenseService;
import com.example.homebudget.api.expanse.request.RegisterExpenseRequest;
import com.example.homebudget.infrastructure.expanse.ExpensesRepository;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import static com.example.homebudget.api.expanse.ExpansesController.EXPENSES_BASE_PATH;

@RestController
@RequestMapping(EXPENSES_BASE_PATH)
class ExpansesController {

    static final String EXPENSES_BASE_PATH = "/expenses";

    private final ExpenseService expenseService;



    public ExpansesController(ExpenseService expenseService, ExpensesRepository expensesRepository) {
        this.expenseService = expenseService;
    }


    //displaying the created expense
    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDto> getSingleExpense( @PathVariable String expenseId) {
        Optional<Expense> expenseById = expenseService.findExpenseByExpenseId(new ExpenseId(expenseId));
        return ResponseEntity.of(expenseById.map(ExpenseResponseDto::fromDomain));
    }


    //displaying all expenses
    @GetMapping()
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpanses() {
        return ResponseEntity.ok(expenseService.findAll().stream().map(ExpenseResponseDto::fromDomain).toList());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



    //expense saving
    @PostMapping
    public ResponseEntity<ExpenseResponseDto> registerNewExpanse(@RequestBody @Valid RegisterExpenseRequest request) {
        Expense newExpense = expenseService.registerNewExpanse(request.title(), request.amount(), request.date(), new BudgetId(request.budgetId()));
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
        Expense expense = new Expense(expenseId, request.amount(), request.title(), request.date(), new BudgetId(request.budgetId()));
        Expense updataExpense = expenseService.updateExpanse(expense);
        return ResponseEntity.created(URI.create("/expenses")).body(updataExpense);
    }

    // partially update expense
    @PatchMapping("/{expenseId}")
    public ResponseEntity<ExpenseResponseDto> partiallyUpdateExpense(@PathVariable("expenseId") ExpenseId expenseId, @Valid @RequestBody PatchExpanseRequest patchExpanseRequest) {
        return ResponseEntity.of(expenseService.updatePatchExpanse(expenseId, patchExpanseRequest.getTitle(), patchExpanseRequest.getAmount(), patchExpanseRequest.getDate(), patchExpanseRequest.getBudgetId())
                .map((ExpenseResponseDto::fromDomain)));
    }


}



