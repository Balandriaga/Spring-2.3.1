package Spring.CRUD.dao;

import Spring.CRUD.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;


import java.util.List;
@Slf4j
@Repository
public class UserDAOImpl implements  UserDAO{

    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
        log.info("User успешно добавлен!");
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
        log.info("User успешно обновлен!");
    }

    @Override
    public void removeUser(long id) {
        User user = em.find(User.class,id);
        if(user!= null) {
            em.remove(user);
            log.info("Пользователь удален");

        }else {
            log.warn("User не найден!");
        }

    }

    @Override
    public User getUserById(long id) {
        User user= em.find(User.class,id);
        if(user==null){
            log.error("Пользователь не найден");
            throw new EntityNotFoundException();
        }
        log.info("User с указанным id успешно найден");
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList =em.createQuery("SELECT u FROM User u",User.class).getResultList();
        return userList;
    }
}
