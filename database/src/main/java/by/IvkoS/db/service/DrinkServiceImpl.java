package by.IvkoS.db.service;

import by.IvkoS.db.dao.DrinkDao;
import by.IvkoS.db.entity.foods.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    DrinkDao drinkDao;

    @Override
    @Transactional
    public Drink addDrink(Drink drink) {
        return drinkDao.create(drink);
    }

    @Override
    public Drink getDrink(int id) {
        return drinkDao.read(id);
    }

    @Override
    @Transactional
    public void removeDrink(Drink drink) {
        drinkDao.delete(drink);
    }

    @Override
    @Transactional
    public Drink updateDrink(Drink drink) {
        return drinkDao.update(drink);
    }
}
