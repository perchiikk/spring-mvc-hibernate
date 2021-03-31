package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    void add(Car car);

    List<Car> getCars();

    Car getCarById(int id);

    void update(Car car);

    void delete(int id);
}
