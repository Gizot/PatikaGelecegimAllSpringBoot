package com.allianz.BlogApp.controller;

import com.allianz.BlogApp.entity.Users;
import com.allianz.BlogApp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping //extra bir path belirtmediğim için buda ana path yani "/users" için çalışacak.
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping //aynı path e hem get hem post mapping işlemi yapabiliriz.
    public Users createUser(@RequestBody Users newUsers) {
        return userService.saveOneUser(newUsers);
    }

    @GetMapping("/{userId}")
    public Users getOneUser(@PathVariable Long userId) {
        //bu user database'de olmayabilir bunun için daha sonra
        //custom exception ekleyeceğiz.şimdilik or else(null) diyeceğiz.
        return userService.getOneUser(userId);
    }

    //Id'si tarafımızca belirlenmiş ve bu var olan Id ile güncelleme
    //işlemi yaptırılmasını istiyorsak putMapping kullanırız.
    @PutMapping("/{userId}")
    public Users updateOneUser(@PathVariable Long userId, @RequestBody Users newUsers) { //bulabildiyse bu user nesnesini
        // update edebilmek için @RequestBody User newUser'ı ekledik.
        return userService.updateOneUser(userId, newUsers);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}


