# CalculatorServlet.java Documentation

## Overview
`CalculatorServlet.java` is a Java Servlet that processes arithmetic operations for the web application. It handles POST requests from the calculator JSP page, performs the requested operation, and redirects with the result.

## Technical Details
- **Package:** servlets
- **Extends:** `HttpServlet`
- **Methods:**
  - `doPost`: Retrieves numbers and operation, computes result, redirects to calculator JSP with result.
- **Input/Output:**
  - Accepts HTTP POST requests from `calculator.jsp`.
  - Uses request parameters: `num1`, `num2`, `operation`.
  - Redirects to `calculator.jsp?result=<value>` with the result or error.
- **Usage:**
  - Mapped to `/calculator` in `web.xml`.
  - Used as the form action in `calculator.jsp`.

## Variables
- `num1Str`: First number as string (String)
- `num2Str`: Second number as string (String)
- `operation`: Operation type (String)
- `result`: Computed result (double)
- `valid`: Validity flag (boolean)

## Dependencies
- Java Servlet API (`javax.servlet.*`)

## Example
- POST `/calculator` with valid numbers and operation → Redirects with result.
- POST `/calculator` with invalid input or division by zero → Redirects with error.

## Author
Generated and documented by GitHub Copilot.
