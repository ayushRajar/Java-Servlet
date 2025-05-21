package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1Str = req.getParameter("num1");
        String num2Str = req.getParameter("num2");
        String operation = req.getParameter("operation");
        double result = 0;
        boolean valid = true;
        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            switch (operation) {
                case "add": result = num1 + num2; break;
                case "subtract": result = num1 - num2; break;
                case "multiply": result = num1 * num2; break;
                case "divide":
                    if (num2 == 0) valid = false;
                    else result = num1 / num2;
                    break;
                default: valid = false;
            }
        } catch (Exception e) {
            valid = false;
        }
        if (valid) {
            resp.sendRedirect("calculator.jsp?result=" + result);
        } else {
            resp.sendRedirect("calculator.jsp?result=Error");
        }
    }
}
