package servlets;

import java.io.IOException; // For handling IO exceptions
import javax.servlet.*;    // For Servlet interfaces
import javax.servlet.http.*; // For HttpServlet and HTTP-specific classes

/**
 * CalculatorServlet
 * -----------------
 * Description: Handles POST requests from the calculator JSP page. Performs arithmetic operations and redirects with the result.
 *
 * Methods:
 *   - doPost: Retrieves numbers and operation, computes result, redirects to calculator JSP with result.
 *
 * Input Arguments:
 *   - HttpServletRequest req: The HTTP request object
 *   - HttpServletResponse resp: The HTTP response object
 *
 * Return Types:
 *   - void
 */
public class CalculatorServlet extends HttpServlet {
    /**
     * doPost
     * Description: Handles POST requests by performing arithmetic operations.
     * @param req HttpServletRequest - the HTTP request
     * @param resp HttpServletResponse - the HTTP response
     * @throws ServletException
     * @throws IOException
     * Variables:
     *   - num1Str: String, stores the first number as a string
     *   - num2Str: String, stores the second number as a string
     *   - operation: String, stores the selected operation
     *   - result: double, stores the computed result
     *   - valid: boolean, indicates if the computation is valid
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1Str = req.getParameter("num1");   // First number as string
        String num2Str = req.getParameter("num2");   // Second number as string
        String operation = req.getParameter("operation"); // Operation type
        double result = 0; // Computed result
        boolean valid = true; // Validity flag
        try {
            double num1 = Double.parseDouble(num1Str); // Parsed first number
            double num2 = Double.parseDouble(num2Str); // Parsed second number
            switch (operation) {
                case "add": result = num1 + num2; break; // Addition
                case "subtract": result = num1 - num2; break; // Subtraction
                case "multiply": result = num1 * num2; break; // Multiplication
                case "divide":
                    if (num2 == 0) valid = false; // Prevent division by zero
                    else result = num1 / num2;
                    break;
                default: valid = false; // Invalid operation
            }
        } catch (Exception e) {
            valid = false; // Parsing or computation error
        }
        if (valid) {
            resp.sendRedirect("calculator.jsp?result=" + result); // Redirect with result
        } else {
            resp.sendRedirect("calculator.jsp?result=Error"); // Redirect with error
        }
    }
}
