package com.allianz.BlogApp.service;

import com.allianz.BlogApp.entity.Users;
import com.allianz.BlogApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users saveOneUser(Users newUsers) {
        return userRepository.save(newUsers);
    }

    public Users getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Users updateOneUser(Long userId, Users newUsers) {
        Optional<Users> user = userRepository.findById(userId); //optional dönüyor o yüzden sol tarafı optional'a aldık
        if (user.isPresent()) {
            Users foundUsers = user.get();
            foundUsers.setUserName((newUsers.getUserName()));
            foundUsers.setPassword(newUsers.getPassword());
            userRepository.save(foundUsers);
            return foundUsers;
        } else
            return null;
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
