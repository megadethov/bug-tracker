package ua.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.mega.dao.PersonDao;
import ua.mega.model.Person;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person createNewPerson(Person person) {
        return personDao.create(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personDao.update(person);
    }

    @Override
    public Person getPersonById(int id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.getAll();
    }
}
