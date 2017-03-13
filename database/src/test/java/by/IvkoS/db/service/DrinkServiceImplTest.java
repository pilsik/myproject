package by.IvkoS.db.service;

import by.IvkoS.db.entity.foods.Drink;
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
public class DrinkServiceImplTest {

    @Autowired
    DrinkService drinkService;

    @Test
    public void addDrink() throws Exception {
        Drink drink = new Drink(11, "test", "test", "test", new byte[]{1, 3, 4}, 10, true);
        drinkService.addDrink(drink);
    }

    @Test
    public void getDrink() throws Exception {
        Drink drink = new Drink(11, "test", "test", "test", new byte[]{1, 3, 4}, 10, true);
        drinkService.addDrink(drink);
        drinkService.getDrink(drink.getId());
    }

    @Test
    public void removeDrink() throws Exception {
        Drink drink = new Drink(11, "test", "test", "test", new byte[]{1, 3, 4}, 10, true);
        drinkService.addDrink(drink);
        drinkService.removeDrink(drink);
    }

    @Test
    public void updateDrink() throws Exception {
        Drink drink = new Drink(11, "test", "test", "test", new byte[]{1, 3, 4}, 10, true);
        drinkService.addDrink(drink);
        Drink drink1 = drinkService.getDrink(drink.getId());
        drink1.setName("test2");
        drinkService.updateDrink(drink);
    }

}