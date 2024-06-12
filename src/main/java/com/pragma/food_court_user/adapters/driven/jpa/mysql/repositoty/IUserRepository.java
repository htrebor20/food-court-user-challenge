package com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
