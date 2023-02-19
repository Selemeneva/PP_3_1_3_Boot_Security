package ru.kata.spring.boot_security.demo.repositories;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;


public interface RoleRepository {
    boolean add(Role user);

    Role getRole(Long id);

    List<Role> getList();

    List<Role> getAllRoles();

    void deleteRole(Long id);

    void editRole(Role role);

    List<Role> listByName(List<String> name);

    Role findByName(String name);
}
