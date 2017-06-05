package dao.impl;


import dao.OrderDao;
import model.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao
{

    @Autowired
    private SessionFactory session;

    @Override
    public List<Order> getAll()
    {
        return session.getCurrentSession().createQuery("from model.Order").list();
    }

    @Override
    public void add(Order order)
    {
        session.getCurrentSession().save(order);
    }
}
