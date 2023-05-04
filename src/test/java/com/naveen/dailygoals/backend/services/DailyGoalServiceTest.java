package com.naveen.dailygoals.backend.services;

import com.naveen.dailygoals.backend.models.DailyGoal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DailyGoalServiceTest {

    @Autowired
    DailyGoalService dailyGoalService;

    @Test
    public void shouldReturnAllDailyGoals() {
        List<DailyGoal> dailyGoals = dailyGoalService.getAllDailyGoals();
        Assertions.assertNotNull(dailyGoals);
    }

    @Test
    public void shouldReturnNullWhenIdNotFound() {
        DailyGoal dailyGoals = dailyGoalService.getDailyGoalById(4L);
        Assertions.assertNull(dailyGoals);
    }

    @Test
    public void shouldReturnDailyGoalForGivenId() {
        DailyGoal dailyGoal = dailyGoalService.getDailyGoalById(1L);

        Assertions.assertNotNull(dailyGoal);
        Assertions.assertEquals("Data Structure", dailyGoal.getGoal());
    }
//
//    @Test
//    public void shouldSaveGivenDailyGoal() {
//        List<DailyGoal> dailyGoals = dailyGoalService.getAllDailyGoals();
//        Assertions.assertNotNull(dailyGoals);
//    }
}
