package ua.mega.dao;

import ua.mega.model.Person;

import java.util.List;

public interface PersonDao {
    Person create(Person person);

    Person update(Person person);

    Person getById(int id);

    List<Person> getAll();
}
