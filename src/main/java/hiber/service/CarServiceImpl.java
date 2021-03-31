package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{
    private CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Transactional
    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }

    @Transactional
    @Override
    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }

    @Transactional
    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Transactional
    @Override
    public void delete(int id) {
        carDao.delete(id);
    }
}
