package taxiapp.service;

import taxiapp.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password);
}
