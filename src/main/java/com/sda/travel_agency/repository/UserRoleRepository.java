package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    boolean existsByName(String name);

    UserRole findByName(String role);
}
