package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * LoginServlet
 * -----------------
 * Description: Displays a login form and validates hardcoded username/password.
 *              On success, redirects to the Calculator page.
 */
public class LoginServlet extends HttpServlet {

    private static final String USERNAME = "mitnick";
    private static final String PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        displayLoginForm(resp, null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Login successful - redirect to calculator servlet
            resp.sendRedirect("calculator");
        } else {
            // Login failed
            displayLoginForm(resp, "Invalid username or password.");
        }
    }

    private void displayLoginForm(HttpServletResponse resp, String errorMessage) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h2>Login</h2>");
        if (errorMessage != null) {
            resp.getWriter().println("<p style='color:red;'>" + errorMessage + "</p>");
        }
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("Username: <input type='text' name='username'><br>");
        resp.getWriter().println("Password: <input type='password' name='password'><br>");
        resp.getWriter().println("<input type='submit' value='Login'>");
        resp.getWriter().println("</form>");
        resp.getWriter().println("</body></html>");
    }
}
