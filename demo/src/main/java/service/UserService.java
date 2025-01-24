package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to save a user to the database
    public <User, S> org.springframework.security.core.userdetails.User saveUser(User user) {
        return userRepository.save(saveUser(null));
    }

    // Method to find a user by email
    public <User> User getUserByEmail(String email) {
        return (User) userRepository.findByEmail(email);
    }
}
