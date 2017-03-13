package by.IvkoS.db.service;

import by.IvkoS.db.entity.order.Order;

public interface OrderService {

    Order addOrder(Order order);

    Order getOrder(int id);

    void removeOrder(Order order);

    Order updateOrder(Order order);

}
