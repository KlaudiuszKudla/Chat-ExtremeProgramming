package org.example.auth.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.auth.entity.Role;
import org.example.auth.entity.User;
import org.example.auth.entity.UserRegisterDTO;
import org.example.auth.exceptions.UserExistingWithMail;
import org.example.auth.exceptions.UserExistingWithName;
import org.example.auth.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public void register(UserRegisterDTO userRegisterDTO) throws UserExistingWithName, UserExistingWithMail {
        userRepository.findUserByLogin(userRegisterDTO.getLogin()).ifPresent(value->{
            log.info("Users alredy exist with this name");
            throw new UserExistingWithName("Users alredy exist with this name");
        });
        userRepository.findUserByEmail(userRegisterDTO.getEmail()).ifPresent(value->{
            log.info("Users alredy exist with this mail");
            throw new UserExistingWithMail("Users alredy exist with this mail");
        });
        User user = new User();
        user.setLocked(true);
        user.setEnabled(false);
        user.setLogin(userRegisterDTO.getLogin());
        user.setPassword(userRegisterDTO.getPassword());
        user.setEmail(userRegisterDTO.getEmail());
        user.setRole(Role.USER);

        saveUser(user);
    }


    private User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }


}
