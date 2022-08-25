package ru.pseudocode.springcourse.dao;

import ru.pseudocode.springcourse.model.Person;

import java.util.List;

public interface PersonDAO {
    public List<Person> index();

    public Person show(int id);
}
