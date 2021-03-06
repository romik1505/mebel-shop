package com.example.mebelshop.repos;

import java.util.Optional;

import com.example.mebelshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    User findUserById(Long id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}