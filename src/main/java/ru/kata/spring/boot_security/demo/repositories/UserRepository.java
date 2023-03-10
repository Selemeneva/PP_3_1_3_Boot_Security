package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;

public interface UserRepository {
    void add(User user);
    Set<User> getList();
    User getUser(Long id);
    void deleteUser(Long id);
    void editUser(Long id, User user);
    UserDetails getUser(String username);
    User showUser(Long id);
}