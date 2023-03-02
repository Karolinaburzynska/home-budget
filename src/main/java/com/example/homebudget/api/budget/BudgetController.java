package com.example.homebudget.api.budget;

import com.example.homebudget.api.budget.request.RegisterBudgetRequest;
import com.example.homebudget.api.budget.response.BudgetResponseDto;
import com.example.homebudget.domain.budget.Budget;
import com.example.homebudget.domain.budget.BudgetId;
import com.example.homebudget.domain.budget.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.net.URI;
import java.util.Optional;

import static com.example.homebudget.api.budget.BudgetController.BUDGET_BASE_PATH;

@RestController
@RequestMapping(BUDGET_BASE_PATH)
class BudgetController {

    static final String BUDGET_BASE_PATH = "/budget";

    private final BudgetService budgetService;

    BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/{budgetId}")
    public ResponseEntity<BudgetResponseDto> getSingleBudget (@PathVariable String budgetId){
        Optional<Budget> budgetById = budgetService.findBudgetById(new BudgetId(budgetId));
        return ResponseEntity.of(budgetById.map(BudgetResponseDto::fromDomain));
    }


    //saving new budget
    @PostMapping
    public ResponseEntity<BudgetResponseDto> registerNewBudget(@RequestBody @Valid RegisterBudgetRequest registerBudgetRequest) {
        Budget newBudget = budgetService.registerNewBudget(registerBudgetRequest.name(), registerBudgetRequest.maxValue(),registerBudgetRequest.budgetType());
        BudgetResponseDto budgetResponseDto = BudgetResponseDto.fromDomain(newBudget);
        return  ResponseEntity.created(URI.create("/budget" + budgetResponseDto.budgetId())).body(budgetResponseDto);
    }
}
