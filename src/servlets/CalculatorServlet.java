package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * CalculatorServlet
 * -------------------
 * Description: A simple servlet that handles GET and POST requests for a calculator form.
 *              On POST, it performs the selected operation on two numbers and displays the result.
 */
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(resp, null, null, null, null); // No data on GET
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1Str = req.getParameter("num1");
        String num2Str = req.getParameter("num2");
        String operation = req.getParameter("operation");
        String result = null;

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            switch (operation) {
                case "add":
                    result = String.valueOf(num1 + num2);
                    break;
                case "subtract":
                    result = String.valueOf(num1 - num2);
                    break;
                case "multiply":
                    result = String.valueOf(num1 * num2);
                    break;
                case "divide":
                    result = (num2 != 0) ? String.valueOf(num1 / num2) : "Error: Divide by zero";
                    break;
                default:
                    result = "Invalid operation";
            }
        } catch (NumberFormatException e) {
            result = "Error: Invalid number format";
        }

        processRequest(resp, num1Str, num2Str, operation, result);
    }

    private void processRequest(HttpServletResponse resp, String num1, String num2, String operation, String result) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h2>Simple Calculator</h2>");
        resp.getWriter().println("<form method='post'>");
        resp.getWriter().println("Number 1: <input type='text' name='num1' value='" + (num1 != null ? num1 : "") + "'><br>");
        resp.getWriter().println("Number 2: <input type='text' name='num2' value='" + (num2 != null ? num2 : "") + "'><br>");
        resp.getWriter().println("Operation: ");
        resp.getWriter().println("<select name='operation'>");
        resp.getWriter().println("<option value='add'" + ("add".equals(operation) ? " selected" : "") + ">Add</option>");
        resp.getWriter().println("<option value='subtract'" + ("subtract".equals(operation) ? " selected" : "") + ">Subtract</option>");
        resp.getWriter().println("<option value='multiply'" + ("multiply".equals(operation) ? " selected" : "") + ">Multiply</option>");
        resp.getWriter().println("<option value='divide'" + ("divide".equals(operation) ? " selected" : "") + ">Divide</option>");
        resp.getWriter().println("</select><br>");
        resp.getWriter().println("<input type='submit' value='Calculate'>");
        resp.getWriter().println("</form>");

        if (result != null) {
            resp.getWriter().println("<h3>Result: " + result + "</h3>");
        }

        resp.getWriter().println("</body></html>");
    }
}
