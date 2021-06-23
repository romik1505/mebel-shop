package com.example.mebelshop.repos;

import java.util.Optional;

import com.example.mebelshop.models.ERole;
import com.example.mebelshop.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(ERole name);
}