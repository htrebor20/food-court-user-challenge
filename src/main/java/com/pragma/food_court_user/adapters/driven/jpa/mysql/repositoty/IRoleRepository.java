package com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(String role);
}
