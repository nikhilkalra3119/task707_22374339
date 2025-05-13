package web.handler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

public class LoginServlet extends HttpServlet {

    // Handling GET requests - serving login form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[LoginServlet] GET");

        // Serve a basic HTML login form
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Login</title></head><body>");
        out.println("<form action='/login' method='post'>");
        out.println("Username: <input type='text' name='username' id='username'><br>");
        out.println("Password: <input type='password' name='passwd' id='passwd'><br>");
        out.println("Date of Birth: <input type='date' name='dob' id='dob'><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form></body></html>");
    }

    // Handling POST requests - processing login form submission
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[LoginServlet] POST");

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        System.out.println("Received: " + username + ", " + password + ", " + dob);

        String loginStatus = "fail";  // Default login failure status

        // Validate the inputs
        if (username != null && password != null && dob != null) {
            // Check credentials using LoginService
            if (LoginService.login(username, password, dob)) {
                loginStatus = "success";
            }
        }

        System.out.println("Login result: " + loginStatus);

        // Construct the HTML response with the appropriate status title
        String htmlResponse = "<html><head><title>" + (loginStatus.equals("success") ? "Login Successful" : "Login Failed") + "</title></head>";
        htmlResponse += "<body><h2>Login status: " + loginStatus + "</h2></body></html>";

        // Write the response back to the client
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
    }

    // Closing curly brace for the class LoginServlet
}