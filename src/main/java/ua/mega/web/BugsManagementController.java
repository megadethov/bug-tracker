package ua.mega.web;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.mega.model.*;
import ua.mega.service.BugService;
import ua.mega.service.PersonService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/bug")
public class BugsManagementController {

    @Autowired
    private BugService bugService;
    @Autowired
    private PersonService personService;

    /**
     * VIEW ALL BUGS
     */
    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public String viewAllBugs(Model model) {
        List<Bug> allBugs = bugService.getAllBugs();
        model.addAttribute("allBugs", allBugs);
        return "view-all-bugs";
    }

    /**
     * VIEW ALL BUGS BY ASSIGNEE NAME
     */
    @RequestMapping(value = "/viewAllByAssigneeName", method = RequestMethod.GET)
    public String viewAllBugsByAssigneeName(Model model) {
        String currentPersonName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Bug> allBugs = bugService.getAllBugsByAssigneeName(currentPersonName);
        model.addAttribute("allBugs", allBugs);
        return "view-all-assignee-bugs";
    }

    /**
     * ADD NEW BUG
     */
    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("bug", new Bug());
        return "add-new-bug";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public ModelAndView processAddForm(@ModelAttribute("bug") @Valid Bug newBug, Errors result) {

        if (result.hasErrors()) {
            return new ModelAndView("add-new-bug", "bug", newBug);
        }
        bugService.createNewBug(newBug);
        return new ModelAndView("bug-added", "bug", newBug);
    }

    /**
     * FORM ATTRIBUTES
     */
    @ModelAttribute("resolutionOptions")
    public List<String> getResolutions() {
        return new ArrayList<>(EnumUtils.getEnumMap(Resolution.class).keySet());
    }

    @ModelAttribute("priorityOptions")
    public List<String> getPriorities() {
        return new ArrayList<>(EnumUtils.getEnumMap(Priority.class).keySet());
    }

    @ModelAttribute("bugStatusOptions")
    public List<String> getBugStatuses() {
        return new ArrayList<>(EnumUtils.getEnumMap(BugStatus.class).keySet());
    }

    @ModelAttribute("personNameOptions")
    public List<Person> getPersonNameOptions() {
        return personService.getAllPersons();
    }

    /**
     * UPDATE BUG
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String showUpdateForm(Model model, @RequestParam("id") int id) {
        Bug bugToUpdate = bugService.getBugById(id);
        model.addAttribute("bug", new Bug());
        model.addAttribute("bug", bugToUpdate);
        return "update-bug";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView processUpdateForm(@ModelAttribute("bug") @Valid Bug newBug, Errors result) {
        if (result.hasErrors()) {
            return new ModelAndView("update-bug", "bug", newBug);
        }
        bugService.updateBug(newBug);
        return new ModelAndView("bug-updated", "bug", newBug);
    }

    /**
     * DELETE BUG
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBug(Model model, @RequestParam("id") int id) {
        bugService.deleteBug(id);
        List<Bug> allBugs = bugService.getAllBugs();
        model.addAttribute("allBugs", allBugs);
        return "view-all-bugs";
    }
}
// TODO: 16.10.17 Logging