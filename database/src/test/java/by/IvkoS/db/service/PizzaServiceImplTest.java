package by.IvkoS.db.service;

import by.IvkoS.db.entity.foods.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-db.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback = true)
@Transactional
public class PizzaServiceImplTest {

    @Autowired
    PizzaService pizzaService;

    @Test
    public void addPizza() throws Exception {
        Pizza pizza = new Pizza(1,"test","test","test",new byte[] {1,2,3,4},11,20,"test");
        pizzaService.addPizza(pizza);
    }

    @Test
    public void getPizza() throws Exception {
        Pizza pizza = new Pizza(1,"test","test","test",new byte[] {1,2,3,4},11,20,"test");
        pizzaService.addPizza(pizza);
        pizzaService.getPizza(pizza.getId());
    }

    @Test
    public void removePizza() throws Exception {
        Pizza pizza = new Pizza(1,"test","test","test",new byte[] {1,2,3,4},11,20,"test");
        pizzaService.addPizza(pizza);
        pizzaService.removePizza(pizza);
    }

    @Test
    public void updatePizza() throws Exception {
        Pizza pizza = new Pizza(1,"test","test","test",new byte[] {1,2,3,4},11,20,"test");
        pizzaService.addPizza(pizza);
        Pizza pizza1 = pizzaService.getPizza(pizza.getId());
        pizza1.setName("test2");
        pizzaService.updatePizza(pizza1);
    }

}