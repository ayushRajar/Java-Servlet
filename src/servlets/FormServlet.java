package servlets;

import java.io.IOException; // For handling IO exceptions
import javax.servlet.*;    // For Servlet interfaces
import javax.servlet.http.*; // For HttpServlet and HTTP-specific classes

/**
 * FormServlet
 * -------------
 * Description: Handles GET and POST requests for a simple HTML form that collects user data (name, email, gender).
 *              On POST, displays the submitted data on the same page.
 *
 * Methods:
 *   - doGet: Handles GET requests, displays the form.
 *   - doPost: Handles POST requests, processes form data and displays it.
 *   - processRequest: Renders the form and, if data is present, displays the submitted data.
 *
 * Input Arguments:
 *   - HttpServletRequest req: The HTTP request object (for doGet/doPost)
 *   - HttpServletResponse resp: The HTTP response object (for all methods)
 *   - String name: The user's name (for processRequest)
 *   - String email: The user's email (for processRequest)
 *   - String gender: The user's gender (for processRequest)
 *
 * Return Types:
 *   - void (all methods)
 */
public class FormServlet extends HttpServlet {
    /**
     * doGet
     * Description: Handles GET requests by displaying the form.
     * @param req HttpServletRequest - the HTTP request
     * @param resp HttpServletResponse - the HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(resp, null, null, null); // No data on GET
    }

    /**
     * doPost
     * Description: Handles POST requests by processing form data and displaying it.
     * @param req HttpServletRequest - the HTTP request
     * @param resp HttpServletResponse - the HTTP response
     * @throws ServletException
     * @throws IOException
     * Variables:
     *   - name: String, stores the user's name from the form
     *   - email: String, stores the user's email from the form
     *   - gender: String, stores the user's gender from the form
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");   // User's name
        String email = req.getParameter("email"); // User's email
        String gender = req.getParameter("gender"); // User's gender
        processRequest(resp, name, email, gender); // Pass data to renderer
    }

    /**
     * processRequest
     * Description: Renders the HTML form and, if data is present, displays the submitted data.
     * @param resp HttpServletResponse - the HTTP response
     * @param name String - user's name (nullable)
     * @param email String - user's email (nullable)
     * @param gender String - user's gender (nullable)
     * @throws IOException
     * Variables:
     *   - name: String, user's name
     *   - email: String, user's email
     *   - gender: String, user's gender
     */
    private void processRequest(HttpServletResponse resp, String name, String email, String gender) throws IOException {
        resp.setContentType("text/html"); // Set response type
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h2>User Form</h2>");
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("Name: <input type='text' name='name'><br>");
        resp.getWriter().println("Email: <input type='email' name='email'><br>");
        resp.getWriter().println("Gender: ");
        resp.getWriter().println("<select name='gender'>");
        resp.getWriter().println("<option value='Male'>Male</option>");
        resp.getWriter().println("<option value='Female'>Female</option>");
        resp.getWriter().println("<option value='Other'>Other</option>");
        resp.getWriter().println("</select><br>");
        resp.getWriter().println("<input type='submit' value='Submit'>");
        resp.getWriter().println("</form>");

        // If all fields are present, display the submitted data
        if (name != null && email != null && gender != null) {
            resp.getWriter().println("<h3>Submitted Data:</h3>");
            resp.getWriter().println("Name: " + name + "<br>");
            resp.getWriter().println("Email: " + email + "<br>");
            resp.getWriter().println("Gender: " + gender + "<br>");
        }
        resp.getWriter().println("</body></html>");
    }
}
