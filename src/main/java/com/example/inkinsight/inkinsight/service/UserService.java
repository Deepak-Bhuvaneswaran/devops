package com.example.inkinsight.inkinsight.service;

import com.example.inkinsight.inkinsight.model.User;
import com.example.inkinsight.inkinsight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> authenticate(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password));
    }
}