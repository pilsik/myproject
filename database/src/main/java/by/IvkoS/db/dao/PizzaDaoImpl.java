package by.IvkoS.db.dao;

import by.IvkoS.db.entity.foods.Pizza;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaDaoImpl extends GenericDaoJpaImpl<Pizza,Integer> implements PizzaDao {
}
