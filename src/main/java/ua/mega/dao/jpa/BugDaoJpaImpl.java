package ua.mega.dao.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.mega.dao.BugDao;
import ua.mega.model.Bug;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BugDaoJpaImpl implements BugDao {
    private static final Logger LOG = LoggerFactory.getLogger(BugDaoJpaImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Bug create(Bug bug) {
        em.persist(bug);
        LOG.debug("Create bug - " + bug);
        return bug;
    }

    @Override
    public Bug update(Bug bug) {
        em.merge(bug);
        LOG.debug("Update bug - " + bug);
        return bug;
    }

    @Override
    public boolean delete(int id) {
        Bug redundantBug = em.find(Bug.class, id);
        LOG.debug("Delete bug - " + redundantBug);
        em.remove(redundantBug);
        return true;
    }

    @Override
    public Bug getById(int id) {
        LOG.debug("Get bug by id - " + id);
        return em.find(Bug.class, id);
    }

    @Override
    public List<Bug> getAll() {
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getAll", Bug.class);
        LOG.debug("Get all bugs");
        return q.getResultList();
    }

    @Override
    public List<Bug> getAllByAssignee(int id) {
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getAllByAssignee", Bug.class).setParameter("id", id);
        LOG.debug("Get all bugs by assignee with id - " + id);
        return q.getResultList();
    }

    @Override
    public List<Bug> getAllByReporter(int id) {
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getAllByReporter", Bug.class).setParameter("id", id);
        LOG.debug("Get all bugs by reporter with id - " + id);
        return q.getResultList();
    }
}