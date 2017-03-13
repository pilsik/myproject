package by.IvkoS.db.service;

import by.IvkoS.db.dao.OrderDao;
import by.IvkoS.db.entity.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    public static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDao orderDao;

    @Override
    public Order addOrder(Order order) {
        logger.info("Order add :" + order);
        return orderDao.create(order);
    }

    @Override
    public Order getOrder(int id) {
        logger.info("Order get with id :" + id);
        return orderDao.read(id);
    }

    @Override
    public void removeOrder(Order order) {
        logger.info("Order delete :" + order);
        orderDao.delete(order);
    }

    @Override
    public Order updateOrder(Order order) {
        logger.info("Order update :" + order);
        return orderDao.update(order);
    }
}
