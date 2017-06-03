package service.impl;

import dao.CarDao;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CarService;

import java.util.*;

@Service
public class CarServiceImpl implements CarService
{

    @Autowired
    private CarDao carDao;

    public Car get(int id)
    {
        Car car = carDao.get(id);
        if (car == null || car.isEnabled() == false)
            return null;
        return car;
    }

    public List<Car> getAll()
    {
        List<Car> list = carDao.getAll();
        List<Car> result = new ArrayList<>();
        for (Car car : list)
            if (car.isEnabled())
                result.add(car);
        return result;
    }

    @Override
    public List<Car> getAllAdmin()
    {
        return carDao.getAll();
    }

    @Override
    public List<Car> getSortedList()
    {
        List<Car> list = carDao.getAll();
        Collections.sort(list, (a, b) -> a.getCompany().compareTo(b.getCompany()));
        return list;
    }

    @Override
    public List<Car> search(Car car)
    {
        List<Car> res = new ArrayList<>();
        List<Car> list = carDao.getAll();
        for (Car c : list)
        {
            if (car.getCompany().equals(c.getCompany()))
            {
                if (car.getModel().isEmpty())
                {
                    if (car.getYear() == 0 || car.getYear() == c.getYear())
                        res.add(c);
                }
                else if (car.getModel().equals(c.getModel()))
                {
                    if (car.getYear() == 0 || car.getYear() == c.getYear())
                        res.add(c);
                }
            }
        }
        return res;
    }

    public void add(Car car)
    {
        carDao.add(car);
    }

    public void update(Car car)
    {
        carDao.update(car);
    }

    public void delete(Car car)
    {
        carDao.delete(car);
    }
}
