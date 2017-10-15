package ua.mega.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.mega.model.*;
import ua.mega.util.DbPopulator;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class BugServiceImplTest {

    @Autowired
    private BugService bugService;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void createNewBug() throws Exception {
       Bug bug = new Bug("Nothing works", Resolution.UNRESOLVED, Priority.HIGH, BugStatus.TO_DO,
                new Person("Milos Sarcev"), new Person( "Alice Cooper"));
        Bug newBug = bugService.createNewBug(bug);
        assertEquals(bug, newBug);
    }

    @Test
    public void updateBug() throws Exception {
        Bug bug = bugService.getBugById(40001);
        bug.setName("CHANGED BUG NAME");
        Bug updateBug = bugService.updateBug(bug);
        assertEquals(bug, updateBug);
    }

    @Test
    public void deleteBug() throws Exception {
        boolean deleteBug = bugService.deleteBug(40001);
        assertEquals(true, deleteBug);
    }

    @Test
    public void getBugById() throws Exception {
        Bug bug = bugService.getBugById(40001);
        assertNotNull(bug);
    }

    @Test(expected = AssertionError.class)
    public void getBugByNotExistId() throws Exception {
        Bug bug = bugService.getBugById(666);
        assertNotNull(bug);
    }

    @Test
    public void getAllBugs() throws Exception {
        List<Bug> allBugs = bugService.getAllBugs();
        assertEquals(false, allBugs.isEmpty());
    }

    @Test
    public void getAllBugsByAssignee() throws Exception {
        List<Bug> allBugsByAssignee = bugService.getAllBugsByAssignee(10001);
        assertEquals(2, allBugsByAssignee.size());
    }

    @Test
    public void getAllBugsByReporter() throws Exception {
        List<Bug> allBugsByReporter = bugService.getAllBugsByReporter(20001);
        assertEquals(2, allBugsByReporter.size());
    }

}