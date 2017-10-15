package ua.mega;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.mega.model.*;
import ua.mega.service.BugService;
import ua.mega.service.PersonService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        PersonService personService = container.getBean(PersonService.class);
        BugService bugService = container.getBean(BugService.class);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        personService.createNewPerson(new Person("name", "lastName"));
/*        List<Person> allPersons = personService.getAllPersons();
        for (Person next : allPersons) {
            System.out.println(next);
        }*/

/*        Bug bug = new Bug("Authenticator code not working", Resolution.UNRESOLVED, Priority.HIGH, BugStatus.TO_DO,
                new Person("Shawn", "Ray"), new Person("Tom", "Araya"));

        bugService.createNewBug(bug);*/

/*        List<Bug> allBugs = bugService.getAllBugsByAssignee(10001);
        for (Bug next : allBugs) {
            System.out.println(next);
        }*/

/*        Bug bugById = bugService.getBugById(1);
        System.out.println(bugById);*/


        tx.commit();
        em.close();
        emf.close();
    }
}
