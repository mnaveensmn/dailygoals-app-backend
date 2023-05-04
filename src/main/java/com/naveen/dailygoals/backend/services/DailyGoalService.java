package com.naveen.dailygoals.backend.services;

import com.naveen.dailygoals.backend.models.DailyGoal;
import com.naveen.dailygoals.backend.repositories.DailyGoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyGoalService {

    private final DailyGoalRepository dailyGoalRepository;

    public DailyGoalService(DailyGoalRepository dailyGoalRepository) {
        this.dailyGoalRepository = dailyGoalRepository;
    }

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

    public void deleteDailyGoalById(Long id) {
        dailyGoalRepository.deleteById(id);
    }

}
