package ua.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mega.dao.PersonDao;
import ua.mega.model.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

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
