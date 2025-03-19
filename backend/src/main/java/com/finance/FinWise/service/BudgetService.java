package com.finance.FinWise.service;

import com.finance.FinWise.model.Budget;
import com.finance.FinWise.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getBudgetsByUserId(Long userId) {
        return budgetRepository.findByUserUserId(userId);
    }

    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Long budId) {
        budgetRepository.deleteById(budId);
    }
}
