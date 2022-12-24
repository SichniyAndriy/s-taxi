package taxiapp.dao;

import java.util.List;
import taxiapp.model.Car;

public interface CarDao extends GenericDao<Car> {
    List<Car> getAllByDriver(Long driverId);
}
