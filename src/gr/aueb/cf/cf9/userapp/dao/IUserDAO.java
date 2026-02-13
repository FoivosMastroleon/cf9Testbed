package gr.aueb.cf.cf9.userapp.dao;

import gr.aueb.cf.cf9.userapp.exception.UserAlreadyExistsException;
import gr.aueb.cf.cf9.userapp.model.User;

import java.util.Optional;

public interface IUserDAO {

    void insert(User user) throws UserAlreadyExistsException;
    void update(User user);
    Optional<User> findByUsername(String username);

    boolean exists(String username);
}
