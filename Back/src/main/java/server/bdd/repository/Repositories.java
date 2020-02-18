package server.bdd.repository;

import org.springframework.stereotype.Component;

@Component
public class Repositories {
    public static UserRepository userRepository;

    public Repositories(UserRepository userRepository) {
        Repositories.userRepository = userRepository;
    }

    public UserRepository getUsers() {
        return userRepository;
    }
}
