package Spring.CRUD.serviсe;

import Spring.CRUD.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(Long id);
    public User getUserById(Long id);
    public List<User> getAll();
}
