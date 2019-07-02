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
<h2>Create country form</h2>
<form:form action="/country/create" method="POST" modelAttribute="country">
    Country name: <form:input path="countryName"/> <br />
    Continent:
    <select name="continent">
        <c:set var="selected" value=""/>
        <c:forEach items="${country.continent}" var="continent">
            <option value="${continent.name}"></option>
        </c:forEach>
    </select>
    <br/>

    <input type="submit" value="Create"/>
</form:form>
</body>
</html>