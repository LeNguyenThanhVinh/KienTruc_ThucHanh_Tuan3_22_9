package com.example.spring_boot_jwt_lntv.controller;

import com.example.spring_boot_jwt_lntv.authen.UserPrincipal;
import com.example.spring_boot_jwt_lntv.entity.Token;
import com.example.spring_boot_jwt_lntv.entity.User;
import com.example.spring_boot_jwt_lntv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        UserPrincipal userPrincipal =
                userService.findByUsername(user.getUsername());

        if (null == user || !new BCryptPasswordEncoder()
                .matches(user.getPassword(), userPrincipal.getPassword())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login Success!!!");
    }




//    Object principal = SecurityContextHolder
//            .getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//        UserPrincipal userPrincipal = (UserPrincipal) principal;
//    }

}
