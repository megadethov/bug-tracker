package ua.mega.service;

import ua.mega.model.Person;

import java.util.List;

public interface PersonService {
    Person createNewPerson(Person person);

    Person updatePerson(Person person);

    Person getPersonById(int id);

    List<Person> getAllPersons();
}
