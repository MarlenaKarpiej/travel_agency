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
<h2>Create airport form</h2>
<form:form action="/airport/create/${cityId}" method="POST" modelAttribute="newAirport">
    City name: <c:out value="${cityName}"/><br/>
    Airport name: <form:input path="airportName"/> <br />
    Property class: <form:input path="propertyClass"/> <br />
    Description: <form:input path="description"/> <br />
    <br/>

    <input type="submit" value="Create"/>
</form:form>
</body>
</html>