package taxiapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taxiapp.lib.Injector;
import taxiapp.model.Driver;
import taxiapp.service.AuthenticationService;

public class LoginController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private static final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("msg", "You don't authentication. Please login");
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Driver driver = authenticationService.login(login, password);
        if (driver != null) {
            req.getSession().setAttribute("id", driver.getId());
            resp.sendRedirect("/index");
        } else {
            resp.sendRedirect("/");
        }
    }
}
