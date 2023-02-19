package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> allUsers();
    void addUser(User user);
    User showUser(Long id);
    void deleteUser(Long id);
    User findByUsername(String username);
    User getUser(Long id);
    List<Role> getAllRoles();
    void editUser(Long id, User user);
}