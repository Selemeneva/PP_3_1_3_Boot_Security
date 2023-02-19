package ru.kata.spring.boot_security.demo.service;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {

    boolean add(Role role);
    List<Role> getList();
    Role getRole(Long id);
    void deleteRole(Long id);
    void editRole(Role role);
    List<Role> listByRole(List<String> name);
    List<Role> getAllRoles();
}