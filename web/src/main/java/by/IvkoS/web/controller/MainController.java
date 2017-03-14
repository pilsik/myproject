package by.IvkoS.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    protected final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index() {
        logger.info("Returning index view");
        return new ModelAndView("home");
    }

}
