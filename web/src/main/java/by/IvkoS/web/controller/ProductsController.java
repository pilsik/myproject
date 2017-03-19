package by.IvkoS.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductsController {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showAllProducts(){
    return "allProduct";
    }
}
