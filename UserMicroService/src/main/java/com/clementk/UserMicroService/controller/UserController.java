package com.clementk.UserMicroService.controller;

import com.clementk.UserMicroService.VO.ResponseTemplateVo;
import com.clementk.UserMicroService.entity.User;
import com.clementk.UserMicroService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside save user of user controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside get user of user controller");
        return userService.getUserWithDepartment(userId);
    }
}
