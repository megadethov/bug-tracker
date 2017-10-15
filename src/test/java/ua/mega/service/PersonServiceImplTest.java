package ua.mega.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.mega.model.Person;
import ua.mega.util.DbPopulator;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void createNewPerson() throws Exception {
        Person person = new Person("Milos Sarcev");
        Person newPerson = personService.createNewPerson(person);
        assertEquals(person, newPerson);
    }

    @Test
    public void updatePerson() throws Exception {
        Person person = personService.getPersonById(10001);
        person.setName("CHANGE_NAME");
        Person updatePerson = personService.updatePerson(person);
        assertEquals(person, updatePerson);
    }

    @Test
    public void getPersonById() throws Exception {
        Person person = personService.getPersonById(10001);
        assertNotNull(person);
    }

    @Test(expected = AssertionError.class)
    public void getPersonByNotExistId() throws Exception {
        Person person = personService.getPersonById(666);
        assertNotNull(person);
    }

    @Test
    public void getAllPersons() throws Exception {
        List<Person> allPersons = personService.getAllPersons();
        assertEquals(false, allPersons.isEmpty());
    }

}