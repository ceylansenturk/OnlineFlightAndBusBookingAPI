package com.logo.bookinguserticket.Controller;


import com.logo.bookinguserticket.Dto.UserChangeInfoRequest;
import com.logo.bookinguserticket.Dto.UserLoginRequest;
import com.logo.bookinguserticket.Dto.UserRegisterRequest;
import com.logo.bookinguserticket.Model.User;
import com.logo.bookinguserticket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService userService;

    // kullanıcı kayıt olur
    @PostMapping("/register")
    public User register(@RequestBody UserRegisterRequest userRegisterRequest){
        return userService.register(userRegisterRequest);
    }
    //kullanıcı email ve şifre ile login olur
    @GetMapping("/login")
    public String login(@RequestBody UserLoginRequest userLoginRequest){
        return userService.login(userLoginRequest);
    }
    // id ile isim ve password güncellenir
    @PutMapping("/{userId}")
    public void changeName(@PathVariable int userId, @RequestBody UserChangeInfoRequest userChangeInfoRequest){
        userService.updateUser(userId, userChangeInfoRequest);
    }
    //Bütün kullanıcılar sorgulanır
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{userId}")
    public List<User> findById(@PathVariable Integer userId) {
        return (List<User>) userService.findById(userId);
    }




}