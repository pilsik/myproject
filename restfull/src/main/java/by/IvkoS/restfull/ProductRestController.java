package by.IvkoS.restfull;

import by.IvkoS.mongodb.models.Product;
import by.IvkoS.mongodb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/allProducts", method = RequestMethod.GET)
    public List<Product> welcome() {
        return productService.getAll();
    }

    @RequestMapping(value = "/allProducts/{type}", method = RequestMethod.GET)
    public List<Product> welcome(@PathVariable String type) {
        return productService.getAllByType(type);
    }
}
