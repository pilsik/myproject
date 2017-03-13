package by.IvkoS.db.service;

import by.IvkoS.db.entity.foods.Drink;
import by.IvkoS.db.entity.foods.Food;
import by.IvkoS.db.entity.foods.Pizza;
import by.IvkoS.db.entity.order.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-db.xml")
@TransactionConfiguration(transactionManager="txManager", defaultRollback = true)
@Transactional
public class OrderServiceImplTest {

    @Autowired
    OrderService orderService;


    @Test
    public void addDrink() throws Exception {
        Set<Food> foodSet = new HashSet<>();
        Pizza pizza = new Pizza(1,"test","test","test",new byte[] {1,2,3,4},11,20,"test");
        Drink drink = new Drink(11, "test", "test", "test", new byte[]{1, 3, 4}, 10, true);
        foodSet.add(pizza);
        foodSet.add(drink);
        orderService.addOrder(new Order(foodSet,"test"));
    }

    @Test
    public void getDrink() throws Exception {
        Set<Food> foodSet = new HashSet<>();
        Pizza pizza = new Pizza(1,"test","test","test",new byte[] {1,2,3,4},11,20,"test");
        Drink drink = new Drink(11, "test", "test", "test", new byte[]{1, 3, 4}, 10, true);
        foodSet.add(pizza);
        foodSet.add(drink);
        Order order = new Order(foodSet,"test");
        orderService.addOrder(order);
        orderService.getOrder(order.getId());
    }

    @Test
    public void removeDrink() throws Exception {
        Set<Food> foodSet = new HashSet<>();
        Pizza pizza = new Pizza(1,"test","test","test",new byte[] {1,2,3,4},11,20,"test");
        Drink drink = new Drink(11, "test", "test", "test", new byte[]{1, 3, 4}, 10, true);
        foodSet.add(pizza);
        foodSet.add(drink);
        Order order = new Order(foodSet,"test");
        orderService.addOrder(order);
        orderService.removeOrder(orderService.getOrder(order.getId()));
    }

    @Test
    public void updateDrink() throws Exception {
        Set<Food> foodSet = new HashSet<>();
        Pizza pizza = new Pizza(1,"test","test","test",new byte[] {1,2,3,4},11,20,"test");
        Drink drink = new Drink(11, "test", "test", "test", new byte[]{1, 3, 4}, 10, true);
        foodSet.add(pizza);
        foodSet.add(drink);
        Order order = new Order(foodSet,"test");
        orderService.addOrder(order);
        Order order1 = orderService.getOrder(order.getId());
        order1.setDescriptionOrder("test2");
        orderService.updateOrder(order1);
    }

}