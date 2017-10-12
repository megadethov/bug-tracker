package ua.mega.dao;

import ua.mega.model.Person;

import java.util.List;

public interface PersonDao {
    Person create(Person person);

    Person update(int id);

    List<Person> getAll();


}
