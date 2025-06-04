package com.example.demo.controller;

import com.example.demo.repository.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static com.sun.beans.introspect.PropertyInfo.Name.required;

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
    @DeleteMapping(path="{id}")
    public void delete(@PathVariable(name="id") Long id){
        userService.delete(id);
    }
    @PutMapping(path="{id}")
    public void update(
            @PathVariable Long id,
            @RequestParam(required = false)String email,
            @RequestParam(required =false) String name
    ){
        userService.update(id, email,name);
    }

}
