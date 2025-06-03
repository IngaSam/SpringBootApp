package com.example.demo.controller;

import com.example.demo.repository.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
}

}
