package by.IvkoS.db.service;

import by.IvkoS.db.entity.foods.Drink;

public interface DrinkService {

    Drink addDrink(Drink drink);

    Drink getDrink(int id);

    void removeDrink(Drink drink);

    Drink updateDrink(Drink drink);

}
