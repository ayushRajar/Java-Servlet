# LoginServlet.java Documentation

## Overview
`LoginServlet.java` is a Java Servlet that handles user authentication for the web application. It processes POST requests from the login JSP page, validates credentials, and redirects users accordingly.

## Technical Details
- **Package:** servlets
- **Extends:** `HttpServlet`
- **Methods:**
  - `doPost`: Validates username and password, redirects to calculator or back to login with error.
- **Input/Output:**
  - Accepts HTTP POST requests from `login.jsp`.
  - Uses request parameters: `username`, `password`.
  - Redirects to `calculator.jsp` on success, or back to `login.jsp?error=1` on failure.
- **Usage:**
  - Mapped to `/login` in `web.xml`.
  - Used as the form action in `login.jsp`.

## Variables
- `username`: User's username (String)
- `password`: User's password (String)

## Dependencies
- Java Servlet API (`javax.servlet.*`)

## Example
- POST `/login` with correct credentials → Redirects to calculator.
- POST `/login` with wrong credentials → Redirects back to login with error.

## Author
Generated and documented by GitHub Copilot.
