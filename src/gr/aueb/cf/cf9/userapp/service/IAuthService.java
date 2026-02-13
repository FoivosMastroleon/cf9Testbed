package gr.aueb.cf.cf9.userapp.service;

import gr.aueb.cf.cf9.userapp.exception.InvalidCredentialsException;
import gr.aueb.cf.cf9.userapp.exception.UserAlreadyExistsException;
import gr.aueb.cf.cf9.userapp.exception.WeakPasswordException;
import gr.aueb.cf.cf9.userapp.model.User;
import gr.aueb.cf.cf9.userapp.model.UserCredentials;

public interface IAuthService {

    void register(User user) throws UserAlreadyExistsException, WeakPasswordException;
    User login(UserCredentials credentials) throws InvalidCredentialsException;
}
