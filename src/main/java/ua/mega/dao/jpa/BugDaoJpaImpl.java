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
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getById", Bug.class).setParameter("id", id);
        LOG.debug("Get bug by id - " + id);
        return q.getSingleResult();
    }

    @Override
    public List<Bug> getAll() {
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getAll", Bug.class);
        LOG.debug("Get all bugs");
        return q.getResultList();
    }

    @Override
    public List<Bug> getAllByAssignee(int assigneeId) {
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getAllByAssignee", Bug.class).setParameter("id", assigneeId);
        LOG.debug("Get all bugs by assignee with id - " + assigneeId);
        return q.getResultList();
    }

    @Override
    public List<Bug> getAllByAssigneeName(String assigneeName) {
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getAllByAssigneeName", Bug.class).setParameter("name", assigneeName);
        LOG.debug("Get all bugs by assignee with name - " + assigneeName);
        return q.getResultList();
    }

    @Override
    public List<Bug> getAllByReporter(int reporterId) {
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getAllByReporter", Bug.class).setParameter("id", reporterId);
        LOG.debug("Get all bugs by reporter with id - " + reporterId);
        return q.getResultList();
    }

    @Override
    public List<Bug> getAllByReporterName(String reporterName) {
        TypedQuery<Bug> q = em.createNamedQuery("Bug.getAllByReporterName", Bug.class).setParameter("name", reporterName);
        LOG.debug("Get all bugs by reporter with name - " + reporterName);
        return q.getResultList();
    }
}
