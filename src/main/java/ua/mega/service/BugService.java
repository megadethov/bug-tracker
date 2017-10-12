package ua.mega.service;

import ua.mega.model.Bug;

import java.util.List;

public interface BugService {
    Bug createNewBug(Bug bug);

    Bug updateBug(int id);

    boolean deleteBug(int id);

    List<Bug> getAllBugs();

    List<Bug> getAllBugsByAssignee(int id);

    List<Bug> getAllBugsByReporter(int id);
}
