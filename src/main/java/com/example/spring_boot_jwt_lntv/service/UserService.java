package com.example.spring_boot_jwt_lntv.service;

import com.example.spring_boot_jwt_lntv.authen.UserPrincipal;
import com.example.spring_boot_jwt_lntv.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
