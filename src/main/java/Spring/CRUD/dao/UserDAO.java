package Spring.CRUD.dao;

import Spring.CRUD.model.User;

import java.util.List;

public interface UserDAO {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(long id);

    public User getUserById(long id);

    public List<User> getAll();

}
