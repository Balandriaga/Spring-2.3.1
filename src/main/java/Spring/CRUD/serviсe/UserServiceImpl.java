package Spring.CRUD.serviсe;

import Spring.CRUD.dao.UserDAO;
import Spring.CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);

    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);

    }

    @Override
    public void removeUser(Long id) {
        userDAO.removeUser(id);

    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDAO.getUserById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
