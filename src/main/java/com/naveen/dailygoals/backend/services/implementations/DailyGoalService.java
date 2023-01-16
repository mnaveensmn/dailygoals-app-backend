package com.naveen.dailygoals.backend.services.implementations;

import com.naveen.dailygoals.backend.models.DailyGoal;
import com.naveen.dailygoals.backend.repositories.DailyGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DailyGoalService {

    @Autowired
    DailyGoalRepository dailyGoalRepository;

    public List<DailyGoal> getAllDailyGoals() {
        List<DailyGoal> dailyGoals = new ArrayList<>();
        dailyGoalRepository.findAll().forEach(dailyGoals::add);
        return dailyGoals;
    }
}
