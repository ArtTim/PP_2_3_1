package ru.pseudocode.springcourse.dao;

import org.springframework.stereotype.Repository;
import ru.pseudocode.springcourse.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() { return entityManager.createQuery("select u from User u", User.class).getResultList(); }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    public void delete(int id) {
        entityManager.remove(show(id));
    }
}
