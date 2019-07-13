<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Travel agency</title>
    <link href="/css/style.css"
          rel="stylesheet">
</head>
<body>
<%@include file="fragments/header.jspf" %>


<h3>Login</h3>
<form:form action="/login" method="POST" modelAttribute="newUser">
    Email: <form:input path="email"/> <br />
    Password: <form:input path="password"/> <br />


    <input type="submit" value="login"/>
</form:form>
</body>


</body>
</html>