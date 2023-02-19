package ru.kata.spring.boot_security.demo.default_users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class DefaultUsers {
    private final UserService userService;
    private final RoleServiceImpl roleService;


    public DefaultUsers(UserService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void addFirstUsers() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        List<Role> adminSet = new ArrayList<>();
        List<Role> userSet = new ArrayList<>();

        roleService.add(roleAdmin);
        roleService.add(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);
        User user = new User("user", new BCryptPasswordEncoder().encode("user"),
                "Jane", "Smith", "user@mail.ru", userSet);
        User admin = new User("admin", new BCryptPasswordEncoder().encode("admin"),
                "John", "Smith", "admin@mail.ru", adminSet);

        userService.addUser(user);
        userService.addUser(admin);
    }
}

