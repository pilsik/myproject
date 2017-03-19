package by.IvkoS.web.controller;

import by.IvkoS.mongodb.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    protected final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/allProducts", method = RequestMethod.GET)
    public String showAllProducts(ModelMap modelMap){
        modelMap.addAttribute("products", productService.getAll());
        return "allProduct";
    }

    @RequestMapping(value = "/allProducts/{type}", method = RequestMethod.GET)
    public String showAllProductsByType(@PathVariable String type, ModelMap modelMap){
        modelMap.addAttribute("products",productService.getAllByType(type));
        return "allProduct";
    }

}
