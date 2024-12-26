package com.example.CarSalesSalon.repository;

import com.example.CarSalesSalon.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
   Optional<Role> findByRoleName(String roleName);
}
