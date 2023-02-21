package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
        }

    @GetMapping()
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        return "userList";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("allRoleList", roleService.getAllRoles());
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.editUser(id, user);
        return "redirect:/admin";
    }
}
