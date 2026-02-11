package com.endterm.fitnesstracker.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Workout> workouts = new ArrayList<>();

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public List<Workout> getWorkouts() { return workouts; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}
