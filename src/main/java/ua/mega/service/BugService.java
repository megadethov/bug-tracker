package ua.mega.service;

import ua.mega.model.Bug;

import java.util.List;

public interface BugService {
    Bug createNewBug(Bug bug);

    Bug updateBug(Bug bug);

    boolean deleteBug(int id);

    Bug getBugById(int id);

    List<Bug> getAllBugs();

    List<Bug> getAllBugsByAssignee(int assigneeId);

    List<Bug> getAllBugsByAssigneeName(String assigneeName);

    List<Bug> getAllBugsByReporter(int reporterId);

    List<Bug> getAllBugsByReporterName(String reporterName);
}
