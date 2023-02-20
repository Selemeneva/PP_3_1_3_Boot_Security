package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService{

    Set<User> allUsers();
    void addUser(User user);
    User showUser(Long id);
    void deleteUser(Long id);
    User findByUsername(String username);
    User getUser(Long id);

    void editUser(Long id, User user);
}