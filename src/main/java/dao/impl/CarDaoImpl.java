package dao.impl;


import dao.CarDao;
import model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CarDaoImpl implements CarDao
{

    @Autowired
    private SessionFactory session;


    public Car get(int id)
    {
        return (Car)session.getCurrentSession().get(Car.class, id);
    }

    public List<Car> getAll()
    {
        return session.getCurrentSession().createQuery("from model.Car").list();
    }

    public void add(Car car)
    {
        session.getCurrentSession().save(car);
    }

    public void update(Car car)
    {
        session.getCurrentSession().update(car);
    }

    public void delete(Car car)
    {
        session.getCurrentSession().delete(car);
    }
}
