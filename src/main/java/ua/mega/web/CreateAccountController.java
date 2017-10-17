package ua.mega.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.mega.security.UserFormObject;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/createAccount")
public class CreateAccountController {

    /**
     * this Spring class under the hood makes queries to tables - USERS and ROLES
     */
    @Autowired
    private JdbcUserDetailsManager userManager;

    /**
     * show form
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView("create-account", "userFormObject", new UserFormObject());
    }
    /**
     * process form
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processForm(@Valid UserFormObject newUser, Errors results) {
        if (results.hasErrors()) {
            return new ModelAndView("create-account", "userFormObject", newUser);
        }

        // send them to the database
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));

        User user = new User(newUser.getUsername(), newUser.getPassword(),roles);
        try {
            userManager.createUser(user);
        }catch (DuplicateKeyException e){
            results.rejectValue("username", "username.unique");
            newUser.setPassword(null);
            return new ModelAndView("create-account", "userFormObject", newUser);
        }
        return new ModelAndView("redirect:/person/viewAll");
    }

}
