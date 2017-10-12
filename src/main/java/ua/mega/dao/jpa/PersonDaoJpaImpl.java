package ua.mega.dao.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.mega.dao.PersonDao;
import ua.mega.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonDaoJpaImpl implements PersonDao {
    private static final Logger LOG = LoggerFactory.getLogger(PersonDaoJpaImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Person create(Person person) {
        em.persist(person);
        LOG.debug("Create person - " + person);
        return person;
    }

    @Override
    public Person update(Person person) {
        em.merge(person);
        LOG.debug("Update person - " + person);
        return person;
    }

    @Override
    public Person getById(int id) {
        LOG.debug("Get person by id - " + id);
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> q = em.createNamedQuery("Person.getAll", Person.class);
        LOG.debug("Get all persons");
        return q.getResultList();
    }
}
