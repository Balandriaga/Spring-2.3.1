package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(Long id, User updatedUser);
    User findById(Long id);
    List<User> findAll();
    void delete(long id);
}
