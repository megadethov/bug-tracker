package ua.mega.dao;

import ua.mega.model.Bug;
import ua.mega.model.Person;

import java.util.List;

public interface BugDao {
    Bug create(Bug bug);

    Bug update(Bug bug);

    boolean delete(int id);

    Bug getById(int id);

    List<Bug> getAll();

    List<Bug> getAllByAssignee(int assigneeId);

    List<Bug> getAllByAssigneeName(String assigneeName);

    List<Bug> getAllByReporter(int reporterId);

    List<Bug> getAllByReporterName(String reporterName);
}
