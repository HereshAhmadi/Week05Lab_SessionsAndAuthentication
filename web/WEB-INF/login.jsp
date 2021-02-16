<%-- 
    Document   : login
    Created on : Feb 16, 2021, 12:21:06 AM
    Author     : 699785
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="login">
            <label>Username:</label><input type="text" name="username" value="${username}"><br>
            <label>Password:</label><input type="password" name="password" value="${password}"><br>
            <button value="login" name="login">Login</button><br>
            <p>${message}</p>
        </form>
    </body>
</html>
