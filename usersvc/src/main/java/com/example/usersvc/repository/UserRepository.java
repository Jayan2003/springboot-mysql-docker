package com.example.usersvc.repository;

import com.example.usersvc.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
