package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private SessionFactory sessionFactory;

    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> getCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public Car getCarById(int id) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM  Car where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Car car) {
        sessionFactory.getCurrentSession().update(car);
    }

    @Override
    public void delete(int id) {
        Car car = getCarById(id);
        sessionFactory.getCurrentSession().delete(car);
    }
}
