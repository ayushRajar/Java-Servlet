# FormServlet.java Documentation

## Overview
`FormServlet.java` is a Java Servlet that handles both GET and POST requests for a simple HTML form. The form collects user information (name, email, gender) and, upon submission, displays the submitted data on the same page.

## Technical Details
- **Package:** servlets
- **Extends:** `HttpServlet`
- **Methods:**
  - `doGet`: Renders the form for GET requests.
  - `doPost`: Processes form data and displays it for POST requests.
  - `processRequest`: Helper method to render the form and display submitted data if present.
- **Input/Output:**
  - Accepts HTTP requests and returns HTML responses.
  - Uses request parameters: `name`, `email`, `gender`.
- **Usage:**
  - Mapped to `/form` in `web.xml`.
  - Access via `http://<host>:<port>/form`.

## Variables
- `name`: User's name (String)
- `email`: User's email (String)
- `gender`: User's gender (String)

## Dependencies
- Java Servlet API (`javax.servlet.*`)

## Example
- GET `/form` → Shows the form.
- POST `/form` with data → Shows the form and the submitted data below it.

## Author
Generated and documented by GitHub Copilot.
