package com.fido.controller;

import com.fido.model.User;
import com.fido.model.UserDto;
import com.fido.model.UserResponse;
import com.fido.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getByUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @PostMapping("/post")
    public ResponseEntity<UserResponse> connectionDatabase(@RequestBody UserDto userDto){
        UserResponse userResponse = userService.callUserControllerProcedure( userDto);
        return ResponseEntity.ok(userResponse);
    }


}