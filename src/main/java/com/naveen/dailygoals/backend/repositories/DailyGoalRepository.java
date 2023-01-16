package com.naveen.dailygoals.backend.repositories;

import com.naveen.dailygoals.backend.models.DailyGoal;
import org.springframework.data.repository.CrudRepository;


public interface DailyGoalRepository extends CrudRepository<DailyGoal,Long> {

}
