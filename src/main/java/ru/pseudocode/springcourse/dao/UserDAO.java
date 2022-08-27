package ru.pseudocode.springcourse.dao;

import ru.pseudocode.springcourse.model.User;

import java.util.List;

public interface UserDAO {

    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}
