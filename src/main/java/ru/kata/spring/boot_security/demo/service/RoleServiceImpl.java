package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public boolean add(Role role) {
        roleRepository.add(role);
        return true;
    }

    @Override
    @Transactional
    public List<Role> getList() {
        return roleRepository.getList();
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Override
    @Transactional
    public Role getRole(Long id) {
        return roleRepository.getRole(id);
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteRole(id);
    }

    @Override
    @Transactional
    public void editRole(Role role) {
        roleRepository.editRole (role);
    }
    @Override
    @Transactional
    public List<Role> listByRole(List<String> name) {
        return roleRepository.listByName(name);
    }
}