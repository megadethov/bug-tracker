package ua.mega.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.mega.model.Person;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person(1001, "Shawn", "Ray");
    }

    @Test
    public void createNewPerson() throws Exception {
        Person newPerson = personService.createNewPerson(person);
        assertEquals(person, newPerson);
    }

    @Test
    public void updatePerson() throws Exception {
        Person updatePerson = personService.updatePerson(this.person.getId());
        assertEquals(this.person, updatePerson);
    }

    @Test
    public void getAllPersons() throws Exception {
        List<Person> allPersons = personService.getAllPersons();
        assertEquals(true, allPersons.size() > 0);
    }

}