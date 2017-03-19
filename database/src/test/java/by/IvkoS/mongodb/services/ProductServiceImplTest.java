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
        Product product = new Product("test","test","test",11,"test");
        productService.add(product);
        productService.remove(product.getId());
    }

    @Test
    public void update() throws Exception {
        Product product = new Product("test","test","test",11, "test");
        productService.add(product);
        product.setName("test1test1");
        productService.update(product);
        assertEquals(productService.get(product.getId()).getName(),"test1test1");
        productService.remove(product.getId());
    }

    @Test
    public void get() throws Exception {
        Product product = new Product("test","test","test",11, "test");
        productService.add(product);
        Product product2 = productService.get(product.getId());
        assertEquals(product,product2);
        productService.remove(product.getId());
    }

    @Test
    public void getAll() throws Exception {
        Product product = new Product("test4","test4","test4",11, "test");
        Product product1 = new Product("test4","test4","test4", 11, "test");
        productService.add(product);
        productService.add(product1);
        assertEquals(productService.getAll().size(),2);
        productService.remove(product.getId());
        productService.remove(product1.getId());
    }

    @Test
    public void remove() throws Exception {
        Product product = new Product("test5","test5","test5",11, "test");
        productService.add(product);
        productService.remove(product.getId());
    }

    @Test
    public void fullProductDB() throws Exception {
        Product product1 = new Product("test1","test1","test2",11.20, "test1");
        Product product2= new Product("test2","test1","test2",11.20, "test2");
        Product product3 = new Product("test3","test2","test3",11.20, "test3");
        Product product4= new Product("test4","test3","test4",11.20, "test4");
        Product product5 = new Product("test5","test4","test5",11.20, "test5");
        productService.add(product1);
        productService.add(product2);
        productService.add(product3);
        productService.add(product4);
        productService.add(product5);
    }
}