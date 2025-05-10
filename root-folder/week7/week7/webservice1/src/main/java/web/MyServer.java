package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;

public class MyServer {

    private static final int PORT = 8082;

    public void start() throws Exception {
        // HTTP server listening on port 8082.
        Server server = new Server(PORT);

        // URL routing/mapping handler
        ServletContextHandler handler = new ServletContextHandler(server, "/");

        // Register the WelcomeServlet to handle the root ("/") URL path.
        handler.addServlet(WelcomeServlet.class, "/");

        // Register LoginServlet to handle "/login" URL path.
        handler.addServlet(LoginServlet.class, "/login");

        // Register RegistrationServlet to handle "/reg" URL path.
        handler.addServlet(RegistrationServlet.class, "/reg");

        /*
         * TODO: Register more servlets for each distinct URL path.
         */

        System.out.println("Server started!");
        server.start();
    }

    public static void main(String[] args) throws Exception {
        new MyServer().start();
    }
}