package ua.mega.dao;

import ua.mega.model.Bug;
import ua.mega.model.Person;

import java.util.List;

public interface BugDao {
    Bug create(Bug bug);

    Bug update(int id);

    boolean delete(int id);

    List<Bug> getAll();

    List<Bug> getAllByAssignee(int id);

    List<Bug> getAllByReporter(int id);
}
