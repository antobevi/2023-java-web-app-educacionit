package com.antobevi.javawebappeducacionit.repository;

import com.antobevi.javawebappeducacionit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // La operacion SAVE viene por defecto
    User findByUsername(String username);

}