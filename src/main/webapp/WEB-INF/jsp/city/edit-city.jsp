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
<h3>Edit city form</h3>
<form:form action="/admin/city/edit-city/${city.id}/${countryId}" method="POST" modelAttribute="city">
    Country name: <c:out value="${countryName}"/><br/>
    City name: <form:input path="cityName"/> <br />
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>