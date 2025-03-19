package com.finance.FinWise.repository;

import com.finance.FinWise.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUserUserId(Long userId);
}
