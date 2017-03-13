package by.IvkoS.db.service;

import by.IvkoS.db.dao.PizzaDao;
import by.IvkoS.db.entity.foods.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    PizzaDao pizzaDao;

    @Override
    @Transactional
    public Pizza addPizza(Pizza pizza) {
        return pizzaDao.create(pizza);
    }

    @Override
    public Pizza getPizza(int id) {
        return pizzaDao.read(id);
    }

    @Override
    @Transactional
    public void removePizza(Pizza pizza) {
        pizzaDao.delete(pizza);
    }

    @Override
    @Transactional
    public Pizza updatePizza(Pizza pizza) {
        return pizzaDao.update(pizza);
    }
}
