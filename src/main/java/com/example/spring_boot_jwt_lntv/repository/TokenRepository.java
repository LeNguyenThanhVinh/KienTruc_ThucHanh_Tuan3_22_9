package com.example.spring_boot_jwt_lntv.repository;

import com.example.spring_boot_jwt_lntv.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository
        extends JpaRepository<Token, Long> {

}
