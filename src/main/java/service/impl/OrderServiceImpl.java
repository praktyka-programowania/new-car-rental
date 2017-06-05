package service.impl;


import dao.OrderDao;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getAll()
    {
        List<Order> list = orderDao.getAll();
        Collections.reverse(list);
        return list;
    }


    @Override
    public List<Order> getForUser(String username)
    {
        List<Order> list = getAll();
        List<Order> result = new ArrayList<>();

        for (Order order : list)
        {
            if (order.getClient().getUsername().equals(username))
                result.add(order);
        }
        return result;
    }

    @Override
    public void add(Order order)
    {
        orderDao.add(order);
    }
}
