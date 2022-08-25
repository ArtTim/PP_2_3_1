package ru.pseudocode.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.pseudocode.springcourse.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO {
    private static int PERSON_COUNT;
    private List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person(++PERSON_COUNT, "Tom"));
        personList.add(new Person(++PERSON_COUNT, "Bob"));
        personList.add(new Person(++PERSON_COUNT, "Mike"));
        personList.add(new Person(++PERSON_COUNT, "Bill"));
    }

    @Override
    public List<Person> index() {
        return personList;
    }

    @Override
    public Person show(int id) {
        return personList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
