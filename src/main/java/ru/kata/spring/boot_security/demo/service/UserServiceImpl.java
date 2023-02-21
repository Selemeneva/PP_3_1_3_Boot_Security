package ru.kata.spring.boot_security.demo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Lazy
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Set<User> allUsers() {return userRepository.getList();}

    @Transactional
    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.add(user);
    }

    @Override
    public User showUser(Long id) {return userRepository.showUser(id);}

    @Transactional
    @Override
    public void deleteUser(Long id) {userRepository.deleteUser(id);}

    @Override
    public User findByUsername(String username) {
        User user = (User) userRepository.getUser(username);
        user.getRoles().size();
        return user;
    }

    @Override
    public User getUser(Long id) {return userRepository.getUser(id);}

    @Transactional
    @Override
    public void editUser(Long id, User user) {userRepository.editUser(id, user);}

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Юзер '%s' не найден", username));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.getAuthorities());
    }
}


