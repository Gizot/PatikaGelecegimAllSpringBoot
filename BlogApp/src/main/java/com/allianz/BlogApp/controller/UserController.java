package com.allianz.BlogApp.controller;

import com.allianz.BlogApp.entity.User;
import com.allianz.BlogApp.repository.UserRepository;
import com.allianz.BlogApp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService();
    }

    @GetMapping //extra bir path belirtmediğim için buda ana path yani "/users" için çalışacak.
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping //aynı path e hem get hem post mapping işlemi yapabiliriz.
    public User createUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        //bu user database'de olmayabilir bunun için daha sonra
        //custom exception ekleyeceğiz.şimdilik or else(null) diyeceğiz.
        return userService.getOneUser(userId);
    }

    //Id'si tarafımızca belirlenmiş ve bu var olan Id ile güncelleme
    //işlemi yaptırılmasını istiyorsak putMapping kullanırız.
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) { //bulabildiyse bu user nesnesini
        // update edebilmek için @RequestBody User newUser'ı ekledik.
        return userService.updateOneUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}


