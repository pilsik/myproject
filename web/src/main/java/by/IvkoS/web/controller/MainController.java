package by.IvkoS.web.controller;

import by.IvkoS.db.entity.clients.Address;
import by.IvkoS.db.entity.clients.Client;
import by.IvkoS.db.entity.clients.security.UserProfile;
import by.IvkoS.db.service.UserProfileService;
import by.IvkoS.db.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    protected final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.getAllList();
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index() {
        logger.info("Returning index view");
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String fromLoginIndex() {
        logger.info("Post redirect get");
        return "redirect:/home";
    }

    @RequestMapping(value = "/newclient", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        Client client = new Client();
        Address address = new Address();
        model.addAttribute("client", client);
        model.addAttribute("address", address);
        return "newclient";
    }

    @RequestMapping(value = "/newclient", method = RequestMethod.POST)
    public String saveRegistration(Client client,
                                   BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "redirect:/newclient";
        }

        logger.info("Save client:" + client.toString());
        userService.addClient(client);

        model.addAttribute("success", "User " + client.getLogin() + " has been registered successfully");
        return "registrationsuccess";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.GET)
    public String addAddress(ModelMap model) {
        Address address = new Address();
        model.addAttribute("address", address);
        return "addAddress";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String saveAddress(Address address,Principal principal) {
        String login = principal.getName();
        Client client = userService.findClientByLogin(login);
        client.getAddressSet().add(address);
        userService.updateClient(client);
        return "redirect:/addAddress";
    }
}
