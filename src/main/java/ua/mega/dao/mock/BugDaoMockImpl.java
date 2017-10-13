package ua.mega.dao.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.mega.dao.BugDao;
import ua.mega.model.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BugDaoMockImpl implements BugDao {

    private static final Logger LOG = LoggerFactory.getLogger(BugDaoMockImpl.class);

    Bug bug1 = new Bug(1001, "Authenticator code not working", Resolution.UNRESOLVED, Priority.HIGH, BugStatus.TO_DO,
            new Person(1001, "Shawn", "Ray"), new Person(1002, "Tom", "Araya"));

    Bug bug2 = new Bug(1002, "Unable to login", Resolution.UNRESOLVED, Priority.HIGH, BugStatus.TO_DO,
            new Person(1001, "Shawn", "Ray"), new Person(1002, "Tom", "Araya"));

    Bug bug3 = new Bug(1003, "Captcha image broken", Resolution.UNRESOLVED, Priority.HIGH, BugStatus.TO_DO,
            new Person(1001, "Shawn", "Ray"), new Person(1002, "Tom", "Araya"));

    List<Bug> allBugs = new ArrayList<>();
    List<Bug> allAssigneeBugs = new ArrayList<>();
    List<Bug> allReporterBugs = new ArrayList<>();

    @Override
    public Bug create(Bug bug) {
        LOG.debug("Create bug - " + bug1);
        return bug1;
    }

    @Override
    public Bug update(Bug bug) {
        LOG.debug("Update bug - " + bug1);
        return bug1;
    }

    @Override
    public boolean delete(int id) {
        LOG.debug("Delete Bug with id - " + id);
        return true;
    }

    @Override
    public Bug getById(int id) {
        return bug1;
    }

    @Override
    public List<Bug> getAll() {
        allBugs.add(bug1);
        allBugs.add(bug2);
        allBugs.add(bug3);
        LOG.debug("Get all bugs");
        return allBugs;
    }

    @Override
    public List<Bug> getAllByAssignee(int assigneeId) {
        allBugs.add(bug1);
        allBugs.add(bug2);
        allBugs.add(bug3);
        LOG.debug("Get all bugs for assignee with id - " + assigneeId);
        return allBugs;
    }

    @Override
    public List<Bug> getAllByReporter(int reporterId) {
        allBugs.add(bug1);
        allBugs.add(bug2);
        allBugs.add(bug3);
        LOG.debug("Get all bugs for reporter with id - " + reporterId);
        return allBugs;
    }
}
