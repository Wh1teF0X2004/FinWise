package com.finance.FinWise.repository;

import com.finance.FinWise.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUserUserId(Long userId);
}
