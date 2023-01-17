package com.naveen.dailygoals.backend.services;

import com.naveen.dailygoals.backend.models.DailyGoal;
import com.naveen.dailygoals.backend.repositories.DailyGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DailyGoalService {

    @Autowired
    DailyGoalRepository dailyGoalRepository;

    public List<DailyGoal> getAllDailyGoals() {
        return dailyGoalRepository.findAll();
    }

    public DailyGoal getDailyGoalById(Long id) {
        Optional<DailyGoal> dailyGoal = dailyGoalRepository.findById(id);
        return dailyGoal.orElse(null);
    }

    public void saveDailyGoal(DailyGoal dailyGoal) {
        dailyGoalRepository.save(dailyGoal);
    }

    public void deleteDailyGoalById(DailyGoal dailyGoal) {
        dailyGoalRepository.delete(dailyGoal);
    }

}
