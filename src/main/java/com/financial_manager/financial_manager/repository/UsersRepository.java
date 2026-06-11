package com.financial_manager.financial_manager.repository;

import com.financial_manager.financial_manager.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>{
    public boolean existsByUsername(String username);
}
