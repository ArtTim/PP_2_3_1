package ru.pseudocode.springcourse.serice;

import org.springframework.stereotype.Component;
import ru.pseudocode.springcourse.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(User updatedUser);
    void delete(int id);
}
