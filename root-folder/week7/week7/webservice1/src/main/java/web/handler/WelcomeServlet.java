package web.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Send the login form to the user
        resp.setContentType("text/html");
        
        // Concatenate the HTML content as a string
        resp.getWriter().write(
            "<html>" +
            "<body>" +
            "<h2>Welcome to the Login Page</h2>" +
            "<form action='/login' method='post'>" +
            "Username: <input type='text' name='username'><br>" +
            "Password: <input type='password' name='passwd'><br>" +
            "Date of Birth: <input type='date' name='dob'><br><br>" +
            "<input type='submit' value='Login'>" +
            "</form>" +
            "</body>" +
            "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Simply calls doGet to send the login form again
        doGet(req, resp);
    }
}