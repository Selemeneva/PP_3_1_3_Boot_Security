package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> allUsers() {
        return userRepository.getList();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.add(user);
    }

    @Override
    public User showUser(Long id) {
        return userRepository.showUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByUsername(String username) {
        User user = (User)userRepository.getUser(username);
        user.getRoles().size();
        return user;
    }

    @Transactional
    @Override
    public User getUser(Long id) {
      return userRepository.getUser(id);
    }


    @Transactional
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Transactional
    @Override
    public void editUser(Long id, User user) {
        userRepository.editUser(id, user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Юзер '%s' не найден", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.getAuthorities());
    }
}


