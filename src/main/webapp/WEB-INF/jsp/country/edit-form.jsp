<%@ page import="com.sda.travel_agency.entity.Continent" %>
<%@ page import="java.util.Map" %>
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
<h2>Edit country form</h2>
<form:form action="/country/create/${country.id}" method="POST" modelAttribute="country">
    Country name: <form:input path="countryName"/> <br />
    <%--<select name="continents">--%>
        <%--<c:forEach items="${continents}" var="value">--%>
            <%--<option value="${value}">${value}</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>