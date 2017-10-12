package ua.mega.service;

import ua.mega.model.Person;

import java.util.List;

public interface PersonService {
    Person createNewPerson(Person person);

    Person updatePerson(int id);

    List<Person> getAllPersons();
}
