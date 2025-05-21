# login.jsp Documentation

## Overview
`login.jsp` is a JSP (JavaServer Pages) file that provides a user interface for logging into the web application. It collects a username and password from the user and submits them to the `LoginServlet` for authentication.

## Technical Details
- **Type:** JSP (JavaServer Pages)
- **Form Action:** Submits to `/login` (handled by `LoginServlet`)
- **Fields:**
  - `username`: Text input for the user's username
  - `password`: Password input for the user's password
- **Error Handling:**
  - Displays an error message if the `error` parameter is present in the request (invalid credentials)

## Usage
- Accessed as the entry point for authentication.
- On successful login, user is redirected to `calculator.jsp`.
- On failure, user is redirected back to `login.jsp?error=1`.

## Example
- GET `/login.jsp` → Shows the login form.
- POST `/login` with credentials → Authenticates and redirects accordingly.

## Author
Generated and documented by GitHub Copilot.
