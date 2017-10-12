package ua.mega.service;

import ua.mega.dao.BugDao;
import ua.mega.dao.mock.BugDaoMockImpl;
import ua.mega.model.Bug;

import java.util.List;

public class BugServiceImpl implements BugService {

    private BugDao bugDao;

    public BugDao getBugDao() {
        return bugDao;
    }

    public void setBugDao(BugDao bugDao) {
        this.bugDao = bugDao;
    }

    @Override
    public Bug createNewBug(Bug bug) {
        return bugDao.create(bug);
    }

    @Override
    public Bug updateBug(int id) {
        return bugDao.update(id);
    }

    @Override
    public boolean deleteBug(int id) {
        return bugDao.delete(id);
    }

    @Override
    public List<Bug> getAllBugs() {
        return bugDao.getAll();
    }

    @Override
    public List<Bug> getAllBugsByAssignee(int id) {
        return bugDao.getAllByAssignee(id);
    }

    @Override
    public List<Bug> getAllBugsByReporter(int id) {
        return bugDao.getAllByReporter(id);
    }
}
