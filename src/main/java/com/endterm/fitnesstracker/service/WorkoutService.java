package com.endterm.fitnesstracker.service;

import com.endterm.fitnesstracker.model.User;
import com.endterm.fitnesstracker.model.Workout;
import com.endterm.fitnesstracker.repository.UserRepository;
import com.endterm.fitnesstracker.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout createWorkout(Workout workout) {

        if (workout.getUser() == null ||
                workout.getUser().getId() == null) {
            throw new RuntimeException("User id is required");
        }

        User user = userRepository.findById(workout.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        workout.setUser(user);

        return workoutRepository.save(workout);
    }

    public Workout updateWorkout(Long id, Workout updatedWorkout) {

        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        workout.setType(updatedWorkout.getType());
        workout.setDuration(updatedWorkout.getDuration());
        workout.setCalories(updatedWorkout.getCalories());

        if (updatedWorkout.getUser() != null &&
                updatedWorkout.getUser().getId() != null) {

            User user = userRepository.findById(updatedWorkout.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            workout.setUser(user);
        }

        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long id) {

        if (!workoutRepository.existsById(id)) {
            throw new RuntimeException("Workout not found");
        }

        workoutRepository.deleteById(id);
    }
}

