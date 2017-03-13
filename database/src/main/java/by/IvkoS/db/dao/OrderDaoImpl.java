package by.IvkoS.db.dao;

import by.IvkoS.db.entity.order.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends GenericDaoJpaImpl<Order,Integer> implements OrderDao {
}
