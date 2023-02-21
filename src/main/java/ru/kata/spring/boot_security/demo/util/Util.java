package ru.kata.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class Util {
    private final UserService userService;
    private final RoleServiceImpl roleService;

    public Util(UserService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addFirstUsers() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.add(roleAdmin);
        roleService.add(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);
        User user = new User("user", "user",
                "Jane", "Smith", "user@mail.ru", userSet);
        User admin = new User("admin", "admin",
                "John", "Smith", "admin@mail.ru", adminSet);

        userService.addUser(user);
        userService.addUser(admin);
    }
}

