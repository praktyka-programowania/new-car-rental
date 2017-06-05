package service;

import model.Order;

import java.util.List;

public interface OrderService
{
    List<Order> getAll();
    List<Order> getForUser(String username);

    void add(Order order);
}
