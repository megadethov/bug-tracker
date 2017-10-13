package ua.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.mega.dao.BugDao;
import ua.mega.dao.mock.BugDaoMockImpl;
import ua.mega.model.Bug;

import java.util.List;

@Service
@Transactional
public class BugServiceImpl implements BugService {

    private final BugDao bugDao;

    @Autowired
    public BugServiceImpl(BugDao bugDao) {
        this.bugDao = bugDao;
    }

    @Override
    public Bug createNewBug(Bug bug) {
        return bugDao.create(bug);
    }

    @Override
    public Bug updateBug(Bug bug) {
        return bugDao.update(bug);
    }

    @Override
    public boolean deleteBug(int id) {
        return bugDao.delete(id);
    }

    @Override
    public Bug getBugById(int id) {
        return bugDao.getById(id);
    }

    @Override
    public List<Bug> getAllBugs() {
        return bugDao.getAll();
    }

    @Override
    public List<Bug> getAllBugsByAssignee(int assigneeId) {
        return bugDao.getAllByAssignee(assigneeId);
    }

    @Override
    public List<Bug> getAllBugsByReporter(int reporterId) {
        return bugDao.getAllByReporter(reporterId);
    }
}
