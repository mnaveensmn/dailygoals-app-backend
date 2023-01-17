package com.naveen.dailygoals.backend.controllers;

import com.naveen.dailygoals.backend.models.DailyGoal;
import com.naveen.dailygoals.backend.services.DailyGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class DailyGoalController {

    @Autowired
    private DailyGoalService dailyGoalService;

    @GetMapping("/test")
    public String get() {
        return "Working";
    }

    @GetMapping("/goals")
    public ResponseEntity<List<DailyGoal>> getAllDailyGoals() {
        return new ResponseEntity<>(dailyGoalService.getAllDailyGoals(), HttpStatus.OK);
    }

    @GetMapping("/goals/{id}")
    public ResponseEntity<DailyGoal> getDailyGoalById(@PathVariable Long id) {
        return new ResponseEntity<>(dailyGoalService.getDailyGoalById(id), HttpStatus.OK);
    }

    @PostMapping("/goals")
    public ResponseEntity<Object> saveDailyGoal(@RequestBody DailyGoal dailyGoal) {
        try {
            dailyGoalService.saveDailyGoal(dailyGoal);
            return new ResponseEntity<>(dailyGoal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving the data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/goals/{id}")
    public ResponseEntity<Object> updateDailyGoal(@RequestBody DailyGoal dailyGoal, @PathVariable Long id) {
        try {
            DailyGoal existingDailyGoal = dailyGoalService.getDailyGoalById(id);
            if (existingDailyGoal == null) {
                return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
            }
            existingDailyGoal.setGoal(dailyGoal.getGoal() != null ? dailyGoal.getGoal() : existingDailyGoal.getGoal());
            existingDailyGoal.setPomCount(dailyGoal.getPomCount());
            dailyGoalService.saveDailyGoal(dailyGoal);
            return new ResponseEntity<>(existingDailyGoal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while saving the data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/goals/{id}")
    public ResponseEntity<String> deleteDailyGoalById(@PathVariable Long id) {
        try {
            DailyGoal dailyGoal = dailyGoalService.getDailyGoalById(id);
            if (dailyGoal == null) {
                return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
            }
            dailyGoalService.deleteDailyGoalById(dailyGoal);
            return new ResponseEntity<>("Successfully deleted the daily goal with the id " + id, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while deleting the data", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
