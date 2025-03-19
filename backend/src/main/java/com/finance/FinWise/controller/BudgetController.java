package com.finance.FinWise.controller;

import com.finance.FinWise.model.Budget;
import com.finance.FinWise.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/user/{userId}")
    public List<Budget> getBudgetsByUser(@PathVariable Long userId) {
        return budgetService.getBudgetsByUserId(userId);
    }

    @PostMapping
    public Budget addBudget(@RequestBody Budget budget) {
        return budgetService.addBudget(budget);
    }

    @DeleteMapping("/{budId}")
    public ResponseEntity<?> deleteBudget(@PathVariable Long budId) {
        budgetService.deleteBudget(budId);
        return ResponseEntity.ok("Budget deleted successfully");
    }
}
