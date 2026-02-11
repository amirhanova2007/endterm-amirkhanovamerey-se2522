package com.endterm.fitnesstracker.controller;

import com.endterm.fitnesstracker.model.Workout;
import com.endterm.fitnesstracker.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.createWorkout(workout);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id,
                                 @RequestBody Workout workout) {
        return workoutService.updateWorkout(id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }
}

