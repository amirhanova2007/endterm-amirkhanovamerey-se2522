package com.endterm.fitnesstracker.patterns;

import com.endterm.fitnesstracker.model.Workout;
import com.endterm.fitnesstracker.model.User;

public class WorkoutFactory {

    public static Workout createWorkout(String type, int duration, int calories, User user) {
        return new Workout(type, duration, calories, user);
    }
}

