package servlets;

import java.io.IOException; // For handling IO exceptions
import javax.servlet.*;    // For Servlet interfaces
import javax.servlet.http.*; // For HttpServlet and HTTP-specific classes

/**
 * LoginServlet
 * -------------
 * Description: Handles POST requests from the login JSP page. Authenticates user credentials.
 *
 * Methods:
 *   - doPost: Validates username and password, redirects to calculator or back to login with error.
 *
 * Input Arguments:
 *   - HttpServletRequest req: The HTTP request object
 *   - HttpServletResponse resp: The HTTP response object
 *
 * Return Types:
 *   - void
 */
public class LoginServlet extends HttpServlet {
    /**
     * doPost
     * Description: Handles POST requests by validating credentials.
     * @param req HttpServletRequest - the HTTP request
     * @param resp HttpServletResponse - the HTTP response
     * @throws ServletException
     * @throws IOException
     * Variables:
     *   - username: String, stores the username from the form
     *   - password: String, stores the password from the form
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username"); // User's username
        String password = req.getParameter("password"); // User's password
        // Simple authentication: username=admin, password=admin
        if ("admin".equals(username) && "admin".equals(password)) {
            resp.sendRedirect("calculator.jsp"); // Redirect to calculator on success
        } else {
            resp.sendRedirect("login.jsp?error=1"); // Redirect back to login with error
        }
    }
}
