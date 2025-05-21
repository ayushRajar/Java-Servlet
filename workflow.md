# Workflow for Java Servlet & JSP Web Application

This document describes the detailed workflow of the web application, including user interactions, servlet/JSP responsibilities, and technical flow.

---

## 1. User Accesses Login Page
- **URL:** `http://localhost:8080/YourAppName/login.jsp`
- **Action:**
  - The user is presented with a login form (username and password fields).
  - The form submits a POST request to `/login`.

---

## 2. Login Submission & Authentication
- **Form Action:** `/login` (handled by `LoginServlet`)
- **LoginServlet Responsibilities:**
  - Retrieves `username` and `password` from the request.
  - Checks credentials (valid: `admin`/`admin`).
  - If valid, redirects to `calculator.jsp`.
  - If invalid, redirects back to `login.jsp?error=1` (shows error message).

---

## 3. User Accesses Calculator Page
- **URL:** `http://localhost:8080/YourAppName/calculator.jsp`
- **Action:**
  - The user is presented with a calculator form (two numbers and operation selection).
  - The form submits a POST request to `/calculator`.

---

## 4. Calculator Submission & Processing
- **Form Action:** `/calculator` (handled by `CalculatorServlet`)
- **CalculatorServlet Responsibilities:**
  - Retrieves `num1`, `num2`, and `operation` from the request.
  - Performs the selected arithmetic operation (add, subtract, multiply, divide).
  - Handles division by zero and invalid input.
  - Redirects back to `calculator.jsp?result=...` with the result or error.

---

## 5. Result Display
- **calculator.jsp Responsibilities:**
  - Checks for the `result` parameter in the request.
  - If present, displays the result below the form.

---

## Technical Flow

1. **login.jsp** (JSP) → **LoginServlet** (Servlet) → **calculator.jsp** (JSP) → **CalculatorServlet** (Servlet) → **calculator.jsp** (JSP with result)

---

## Example User Journey

1. User visits `/login.jsp` and enters credentials.
2. If credentials are correct, user is redirected to `/calculator.jsp`.
3. User enters two numbers and selects an operation, then submits the form.
4. The result is displayed on the same page.

---

## Error Handling
- Invalid login credentials: User is redirected back to login with an error message.
- Invalid calculator input (e.g., division by zero): User sees an error message on the calculator page.

---

## Deployment & Access
- Deploy the application to Tomcat as described in `setup.md`.
- Access the app via browser at the login page URL.

---

## Author
Generated and documented by GitHub Copilot.
