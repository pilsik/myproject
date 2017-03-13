package by.IvkoS.db.service;

import by.IvkoS.db.entity.foods.Pizza;

public interface PizzaService {
    Pizza addPizza(Pizza pizza);

    Pizza getPizza(int id);

    void removePizza(Pizza pizza);

    Pizza updatePizza(Pizza pizza);
}
