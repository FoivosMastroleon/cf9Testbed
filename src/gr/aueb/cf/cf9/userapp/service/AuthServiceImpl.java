package gr.aueb.cf.cf9.userapp.service;

import gr.aueb.cf.cf9.userapp.dao.IUserDAO;
import gr.aueb.cf.cf9.userapp.exception.InvalidCredentialsException;
import gr.aueb.cf.cf9.userapp.exception.UserAlreadyExistsException;
import gr.aueb.cf.cf9.userapp.exception.WeakPasswordException;
import gr.aueb.cf.cf9.userapp.model.User;
import gr.aueb.cf.cf9.userapp.model.UserCredentials;
import gr.aueb.cf.cf9.userapp.util.Logger;

import java.util.Optional;

public class AuthServiceImpl implements IAuthService {

    private final IUserDAO userDAO;

    public AuthServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) throws UserAlreadyExistsException, WeakPasswordException {
        // Validate password strength
        PasswordValidator.validate(user.password());

        if (userDAO.exists(user.username())) {
            throw new UserAlreadyExistsException(user.username());
        }

        userDAO.insert(user);
        Logger.info("User registered successfully: " + user.username());
    }

    @Override
    public User login(UserCredentials credentials) throws InvalidCredentialsException {
        Optional<User> userOpt = userDAO.findByUsername(credentials.username());

        if (userOpt.isEmpty()) {
            throw new InvalidCredentialsException("User not found");
        }

        User user = userOpt.get();
        if (!user.password().equals(credentials.password())) {
            throw new InvalidCredentialsException("Invalid password");
        }

        Logger.info("User logged in successfully: " + user.username());
        return user;
    }
}
