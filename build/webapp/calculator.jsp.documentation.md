# calculator.jsp Documentation

## Overview
`calculator.jsp` is a JSP (JavaServer Pages) file that provides a user interface for performing arithmetic operations. It collects two numbers and an operation from the user and submits them to the `CalculatorServlet` for processing.

## Technical Details
- **Type:** JSP (JavaServer Pages)
- **Form Action:** Submits to `/calculator` (handled by `CalculatorServlet`)
- **Fields:**
  - `num1`: Number input for the first operand
  - `num2`: Number input for the second operand
  - `operation`: Dropdown to select the arithmetic operation (Add, Subtract, Multiply, Divide)
- **Result Display:**
  - Displays the result if the `result` parameter is present in the request

## Usage
- Accessed after successful login.
- On form submission, the result is displayed on the same page.

## Example
- GET `/calculator.jsp` → Shows the calculator form.
- POST `/calculator` with numbers and operation → Computes and displays the result.

## Author
Generated and documented by GitHub Copilot.
