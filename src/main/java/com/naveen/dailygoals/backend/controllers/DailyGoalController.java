package com.naveen.dailygoals.backend.controllers;

import com.naveen.dailygoals.backend.models.DailyGoal;
import com.naveen.dailygoals.backend.services.implementations.DailyGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DailyGoalController {

    @Autowired
    private DailyGoalService dailyGoalService;

    @GetMapping("/test")
    public String get() {
        return "Working";
    }

    @GetMapping("/goals")
    public List<DailyGoal> getAllGoals() {
        return dailyGoalService.getAllDailyGoals();
    }

}
