package com.naveen.dailygoals.backend.repositories;

import com.naveen.dailygoals.backend.models.DailyGoal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DailyGoalRepository extends JpaRepository<DailyGoal, Long> {

}
