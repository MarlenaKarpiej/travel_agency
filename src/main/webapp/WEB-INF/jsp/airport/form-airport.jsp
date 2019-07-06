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
<h3>Create airport form</h3>
<form:form action="/admin/airport/create/${cityId}" method="POST" modelAttribute="newAirport">
    City name: <c:out value="${cityName}"/><br/>
    Airport name: <form:input path="airportName"/> <br />
    <br/>

    <input type="submit" value="Create"/>
</form:form>
</body>
</html>