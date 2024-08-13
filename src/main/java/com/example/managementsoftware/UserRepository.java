package com.example.managementsoftware;

import com.example.managementsoftware.Modell.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    List<User> findByRole(String role);

    List<User> findByAgeGreaterThanEqual(Integer age);

    User findByEmail(String email);

    User findByUserName(String username);

}