package ru.pseudocode.springcourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.pseudocode.springcourse.model.User;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
        return users;
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setAge(updatedUser.getAge());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(User.class, id));
    }
}
