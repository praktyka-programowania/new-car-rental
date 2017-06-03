package dao;

import model.Car;

import java.util.List;

public interface CarDao
{
    Car get(int id);
    List<Car> getAll();

    void add(Car car);
    void update(Car car);
    void delete (Car car);

}
