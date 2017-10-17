package ua.mega.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.mega.security.UserFormObject;

import javax.validation.Valid;

@Controller
@RequestMapping("/createAccount")
public class CreateAccountController {

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView("create-account", "userFormObject", new UserFormObject());
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView processForm(@Valid UserFormObject newUser, Errors results)
    {
        if (results.hasErrors())
        {
            return new ModelAndView("create-account", "userFormObject", newUser);
        }

        // send them to the database
        return null;
    }
}
