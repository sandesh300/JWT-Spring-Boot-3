<!-- src/main/webapp/WEB-INF/views/login.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/auth/login" method="post">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required/><br/>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required/><br/>

        <button type="submit">Login</button>
    </form>
</body>
</html>
