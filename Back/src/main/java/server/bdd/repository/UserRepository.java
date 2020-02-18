package server.bdd.repository;

import org.springframework.data.repository.Repository;
import server.bdd.model.User;

public interface UserRepository extends Repository<User, Integer> {
    void save(User user);
    User getByLogin(String login);
    User getByLoginAndPassword(String login, String password);
}
