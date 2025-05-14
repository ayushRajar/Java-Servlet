package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(resp, null, null, null);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        processRequest(resp, name, email, gender);
    }

    private void processRequest(HttpServletResponse resp, String name, String email, String gender) throws IOException {
        resp.setContentType("text/html");
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

        if (name != null && email != null && gender != null) {
            resp.getWriter().println("<h3>Submitted Data:</h3>");
            resp.getWriter().println("Name: " + name + "<br>");
            resp.getWriter().println("Email: " + email + "<br>");
            resp.getWriter().println("Gender: " + gender + "<br>");
        }
        resp.getWriter().println("</body></html>");
    }
}
