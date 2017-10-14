package ua.mega.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.mega.model.Person;
import ua.mega.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/person")
public class PersonsManagementController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public String viewAllPersons(Model model) {
        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("allPersons", allPersons);
        return "view-all-persons";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add-new-person";
    }
    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public ModelAndView processAddForm(@Valid Person newPerson, Errors result) {

        if (result.hasErrors()) {
            return new ModelAndView("add-new-person", "person", newPerson);
        }
        personService.createNewPerson(newPerson);
        return new ModelAndView("person-added", "person", newPerson);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView showUpdateForm(@RequestParam("id") int id) {
        Person personToUpdate = personService.getPersonById(id);
        return new ModelAndView("update-person", "person", personToUpdate);
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView processUpdateForm(@Valid Person newPerson, Errors result) {

        if (result.hasErrors()) {
            return new ModelAndView("update-person", "person", newPerson);
        }
        personService.updatePerson(newPerson);
        return new ModelAndView("person-updated", "person", newPerson);
    }

}