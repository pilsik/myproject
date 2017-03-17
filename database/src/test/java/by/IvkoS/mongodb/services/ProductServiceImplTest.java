package by.IvkoS.mongodb.services;

import by.IvkoS.mongodb.models.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mongo-db.xml")
@Rollback(true)
public class ProductServiceImplTest {

    @Autowired
    ProductService productService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {
        Product product = new Product("test","test","test");
        productService.add(product);
    }

    @Test
    public void update() throws Exception {
        Product product = new Product("test1","test1","test1");
        productService.add(product);
        Product product1 = productService.get(product.getId());
        product1.setName("test1test1");
        productService.update(product);
    }

    @Test
    public void get() throws Exception {
        Product product = new Product("test3","test3","test3");
        productService.add(product);
        Product product2 = productService.get(product.getId());
        assertEquals(product,product2);
    }

    @Test
    public void getAll() throws Exception {
        Product product = new Product("test4","test4","test4");
        Product product1 = new Product("test4","test4","test4");
        productService.add(product);
        productService.add(product1);
        assertEquals(productService.getAll().size(),2);
    }

    @Test
    public void remove() throws Exception {
        Product product = new Product("test5","test5","test5");
        productService.add(product);
        productService.remove(product.getId());

    }

}