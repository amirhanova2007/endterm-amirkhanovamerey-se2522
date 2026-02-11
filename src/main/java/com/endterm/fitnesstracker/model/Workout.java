package com.endterm.fitnesstracker.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int duration;
    private int calories;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("workouts")
    private User user;

    public Workout() {}

    public Workout(String type, int duration, int calories, User user) {
        this.type = type;
        this.duration = duration;
        this.calories = calories;
        this.user = user;
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public int getDuration() { return duration; }
    public int getCalories() { return calories; }
    public User getUser() { return user; }

    public void setType(String type) { this.type = type; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setCalories(int calories) { this.calories = calories; }
    public void setUser(User user) { this.user = user; }
}

