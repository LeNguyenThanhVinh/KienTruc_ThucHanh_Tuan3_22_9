package com.example.spring_boot_jwt_lntv.service;

import com.example.spring_boot_jwt_lntv.entity.Token;

public interface TokenService {
    Token createToken(Token token);
}
