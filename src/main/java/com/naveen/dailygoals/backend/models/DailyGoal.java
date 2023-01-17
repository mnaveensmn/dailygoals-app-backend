package com.naveen.dailygoals.backend.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "daily_goal")
public class DailyGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String goal;

    @Column(name = "pomodoro_count")
    private int pomCount;
}
