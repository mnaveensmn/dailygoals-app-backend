package com.naveen.dailygoals.backend.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "daily_goal")
public class DailyGoal {
    @Id
    @Column
    private long id;

    @Column
    private String goal;

    @Column(name = "pomodoro_count")
    private int pomCount;
}
