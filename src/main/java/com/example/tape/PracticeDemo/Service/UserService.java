package com.example.tape.PracticeDemo.Service;

import com.example.tape.PracticeDemo.Model.User;
import com.example.tape.PracticeDemo.Utils.UserServiceException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final Map<UUID, User> userMap = new ConcurrentHashMap<>();

    public List<User> getAllUsers() {
        try {
            return new ArrayList<>(userMap.values());
        } catch (Exception e) {
            throw new UserServiceException("fetch failed", e);
        }
    }

    public Optional<User> getUserById(UUID id) {
        try {
            return Optional.ofNullable(userMap.get(id));
        } catch (Exception e) {
            throw new UserServiceException("failed user id" + id, e);
        }
    }

    public Optional<User> addUser(User user) {
        try {
            UUID userId = UUID.randomUUID();
            user.setId(userId);
            userMap.put(userId, user);
            return Optional.of(user);
        } catch (Exception e) {
            throw new UserServiceException("failed to add", e);
        }
    }

    public boolean deleteUser(UUID id) {
        try {
            return userMap.remove(id) != null;
        } catch (Exception e) {
            throw new UserServiceException("failed to delete", e);
        }
    }

    public Optional<User> updateUser(UUID id, User updatedUser) {
        try {
            return Optional.ofNullable(userMap.computeIfPresent(id, (key, existingUser) -> {
                existingUser.setName(updatedUser.getName());
                existingUser.setUsername(updatedUser.getUsername());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setAddress(updatedUser.getAddress());
                existingUser.setPhone(updatedUser.getPhone());
                existingUser.setWebsite(updatedUser.getWebsite());
                existingUser.setCompany(updatedUser.getCompany());
                return existingUser;
            }));
        } catch (Exception e) {
            throw new UserServiceException("failed to update" + id, e);
        }
    }
}