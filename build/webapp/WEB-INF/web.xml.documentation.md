# web.xml Documentation

## Overview
`web.xml` is the deployment descriptor for the Java Servlet and JSP web application. It configures servlet classes, their URL mappings, and other web application settings.

## Technical Details
- **Location:** `build/webapp/WEB-INF/web.xml`
- **Servlet Mappings:**
  - `HelloServlet` mapped to `/hello`
  - `FormServlet` mapped to `/form`
  - `LoginServlet` mapped to `/login`
  - `CalculatorServlet` mapped to `/calculator`
- **JSPs:**
  - `login.jsp` (login page)
  - `calculator.jsp` (calculator page)

## Usage
- Required for Tomcat and other Java EE servers to recognize and map servlets.
- Controls which URLs are handled by which servlets.

## Example
- POST `/login` → handled by `LoginServlet`
- POST `/calculator` → handled by `CalculatorServlet`
- GET `/form` → handled by `FormServlet`

## Author
Generated and documented by GitHub Copilot.
