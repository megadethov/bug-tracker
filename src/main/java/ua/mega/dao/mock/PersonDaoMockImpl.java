package ua.mega.dao.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.mega.dao.PersonDao;
import ua.mega.model.Person;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoMockImpl implements PersonDao {
    private static final Logger LOG = LoggerFactory.getLogger(PersonDaoMockImpl.class);

    private Person person1 = new Person(1001, "Shawn", "Ray");
    private Person person2 = new Person(1002, "Flex", "Wheeler");
    private Person person3 = new Person(1003, "Lee", "Priest");

    private List<Person> persons = new ArrayList<>();

    @Override
    public Person create(Person person) {
        LOG.debug("Create person - " + person1);
        return person1;
    }

    @Override
    public Person update(Person person) {
        LOG.debug("Update person - " + person1);
        return person1;
    }

    @Override
    public Person getById(int id) {
        LOG.debug("Get person by id");
        return person1;
    }

    @Override
    public List<Person> getAll() {
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        LOG.debug("Get all persons");
        return persons;
    }
}
