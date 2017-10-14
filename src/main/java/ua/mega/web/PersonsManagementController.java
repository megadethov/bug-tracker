package ua.mega.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.mega.model.Person;
import ua.mega.service.PersonService;

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
    public String processAddForm(Person newPerson) {
        personService.createNewPerson(newPerson);
        return "person-added";
    }

}