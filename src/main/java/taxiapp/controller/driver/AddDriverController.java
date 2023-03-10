package taxiapp.controller.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxiapp.lib.Injector;
import taxiapp.model.Driver;
import taxiapp.service.DriverService;

public class AddDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/drivers/add.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String name = req.getParameter("name");
        String license = req.getParameter("license_number");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("password_repeat");
        if (password.equals(passwordRepeat)) {
            Driver driver = new Driver();
            driver.setName(name);
            driver.setLicenseNumber(license);
            driver.setLogin(login);
            driver.setPassword(password);
            driverService.create(driver);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("msg", "Wrong data. Try again");
            req.getRequestDispatcher("/WEB-INF/views/drivers/add.jsp").forward(req, resp);
        }
    }
}
