package ua.mega.service;

import ua.mega.dao.PersonDao;
import ua.mega.dao.mock.PersonDaoMockImpl;
import ua.mega.model.Person;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person createNewPerson(Person person) {
        return personDao.create(person);
    }

    @Override
    public Person updatePerson(int id) {
        return personDao.update(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.getAll();
    }
}
