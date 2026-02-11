package com.endterm.fitnesstracker.repository;

import com.endterm.fitnesstracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
