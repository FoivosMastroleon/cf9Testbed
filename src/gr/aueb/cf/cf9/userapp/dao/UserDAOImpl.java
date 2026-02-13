package gr.aueb.cf.cf9.userapp.dao;

import gr.aueb.cf.cf9.userapp.exception.UserAlreadyExistsException;
import gr.aueb.cf.cf9.userapp.model.User;
import gr.aueb.cf.cf9.userapp.util.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDAOImpl implements IUserDAO {
    private final File dataFile;
    private Map<String, User> users;

    public UserDAOImpl() {
        String desktopPath = System.getProperty("user.home") + "/Desktop/User Login App";
        File dataDir = new File(desktopPath);
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
        this.dataFile = new File(dataDir, "users.dat");
        this.users = loadUsers();
    }

    @SuppressWarnings("unchecked")
    private Map<String, User> loadUsers() {
        if (!dataFile.exists()) {
            return new HashMap<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile))) {
            return (Map<String, User>) ois.readObject();
        } catch (EOFException e) {
            Logger.info("User data file is empty. Starting with a new user map.");
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            Logger.error("Could not load users from file. The file might be corrupted. Starting with a new user map.", e);
            return new HashMap<>(); // Return empty map on error
        }
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            oos.writeObject(users);
        } catch (IOException e) {
            Logger.error("Could not save users to file", e);
        }
    }

    @Override
    public void insert(User user) throws UserAlreadyExistsException {
        if (exists(user.username())) {
            Logger.warning("Attempt to create a user that already exists: " + user.username());
            throw new UserAlreadyExistsException(user.username());
        }
        users.put(user.username(), user);
        saveUsers();
    }

    @Override
    public void update(User user) {
        users.put(user.username(), user);
        saveUsers();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    @Override
    public boolean exists(String username) {
        return users.containsKey(username);
    }
}
