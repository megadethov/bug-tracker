package ua.mega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mega.dao.BugDao;
import ua.mega.dao.mock.BugDaoMockImpl;
import ua.mega.model.Bug;

import java.util.List;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugDao bugDao;

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
