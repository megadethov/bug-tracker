package ua.mega.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.mega.model.*;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BugServiceImplTest {

    @Autowired
    private BugService bugService;

    private Bug bug;

    @Before
    public void setUp() throws Exception {
        bug = new Bug(1001, "Authenticator code not working", Resolution.UNRESOLVED, Priority.HIGH, BugStatus.TO_DO,
                new Person(1001, "Shawn", "Ray"), new Person(1002, "Tom", "Araya"));
    }

    @Test
    public void createNewBug() throws Exception {
        Bug newBug = bugService.createNewBug(bug);
        assertEquals(bug, newBug);
    }

    @Test
    public void updateBug() throws Exception {
        Bug updateBug = bugService.updateBug(this.bug.getId());
        assertEquals(bug, updateBug);
    }

    @Test
    public void deleteBug() throws Exception {
        boolean deleteBug = bugService.deleteBug(bug.getId());
        assertEquals(true, deleteBug);
    }

    @Test
    public void getAllBugs() throws Exception {
        List<Bug> allBugs = bugService.getAllBugs();
        assertEquals(true, allBugs.size() > 0);
    }

    @Test
    public void getAllBugsByAssignee() throws Exception {
        List<Bug> allBugsByAssignee = bugService.getAllBugsByAssignee(bug.getId());
        assertEquals(true, allBugsByAssignee.size() > 0);
    }

    @Test
    public void getAllBugsByReporter() throws Exception {
        List<Bug> allBugsByReporter = bugService.getAllBugsByReporter(bug.getId());
        assertEquals(true, allBugsByReporter.size() > 0);
    }

}