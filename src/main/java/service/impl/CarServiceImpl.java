package service.impl;

import dao.CarDao;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CarService;

import java.util.ArrayList;
import java.util.List;

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
