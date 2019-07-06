<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Travel agency</title>
    <link href="/css/style.css"
          rel="stylesheet">
</head>
<body>
<%@include file="../fragments/header.jspf" %>
<h2>Edit airport form</h2>
<form:form action="/airport/edit-airport/${airportId}/${cityId}" method="POST" modelAttribute="airport">
    Airport name: <form:input path="airportName"/> <br />
    <br/>
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>