package taxiapp.dao;

import java.util.Optional;
import taxiapp.model.Driver;

public interface DriverDao extends GenericDao<Driver> {
    Optional<Driver> findByLogin(String login);
}
