package ru.kata.spring.boot_security.demo.service;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    boolean add(Role role);
    Set<Role> getList();
    Role getRole(Long id);
    void deleteRole(Long id);
    void editRole(Role role);
    Set<Role> listByRole(Set<String> name);
    Set<Role> getAllRoles();
}