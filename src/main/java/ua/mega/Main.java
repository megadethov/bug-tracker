package ua.mega;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.mega.model.Bug;
import ua.mega.model.Person;
import ua.mega.service.BugService;
import ua.mega.service.PersonService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        PersonService personService = container.getBean(PersonService.class);
        BugService bugService = container.getBean(BugService.class);

        List<Person> allPersons = personService.getAllPersons();

        for (Person next : allPersons) {
            System.out.println(next);
        }

        List<Bug> allBugsByReporter = bugService.getAllBugsByReporter(1001);
        for (Bug next : allBugsByReporter) {
            System.out.println(next);
        }
    }
}
