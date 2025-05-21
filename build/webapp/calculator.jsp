<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h2>Simple Calculator</h2>
    <form action="calculator" method="post">
        Number 1: <input type="number" name="num1" step="any" required><br>
        Number 2: <input type="number" name="num2" step="any" required><br>
        Operation:
        <select name="operation">
            <option value="add">Add</option>
            <option value="subtract">Subtract</option>
            <option value="multiply">Multiply</option>
            <option value="divide">Divide</option>
        </select><br>
        <input type="submit" value="Calculate">
    </form>
    <p>
        <% String result = request.getParameter("result");
           if (result != null) { %>
            <b>Result: <%= result %></b>
        <% } %>
    </p>
</body>
</html>
