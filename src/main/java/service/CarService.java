package service;

import model.Car;

import java.util.List;

public interface CarService
{
    Car get(int id);
    List<Car> search(Car car);
    List<Car> getAll();
    List<Car> getAllAdmin();
    List<Car> getSortedList();

    void add(Car car);
    void update(Car car);
    void delete (Car car);
}
