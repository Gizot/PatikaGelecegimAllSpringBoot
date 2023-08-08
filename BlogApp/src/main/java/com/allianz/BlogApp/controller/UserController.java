package com.allianz.BlogApp.controller;

import com.allianz.BlogApp.entity.User;
import com.allianz.BlogApp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository userRepository;

    //aşağıda constructer injection örneği mevcuttur.
    //Sanki userController nesnesi olusurken biyerden
    //userController'ın içine userRepository geliyor gibi düşün.
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping //extra bir path belirtmediğim için buda ana path yani "/users" için çalışacak.
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping //aynı path e hem get hem post mapping işlemi yapabiliriz.
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        //bu user database'de olmayabilir bunun için daha sonra
        //custom exception ekleyeceğiz.şimdilik or else(null) diyeceğiz.
        return userRepository.findById(userId).orElse(null);
    }

    //Id'si tarafımızca belirlenmiş ve bu var olan Id ile güncelleme
    //işlemi yaptırılmasını istiyorsak putMapping kullanırız.
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) { //bulabildiyse bu user nesnesini
        // update edebilmek için @RequestBody User newUser'ı ekledik.
        Optional<User> user = userRepository.findById(userId); //optional dönüyor o yüzden sol tarafı optional'a aldık
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName((newUser.getUserName()));
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else
            return null;
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}


