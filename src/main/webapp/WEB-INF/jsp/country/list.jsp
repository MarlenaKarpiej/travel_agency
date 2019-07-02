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

<c:if test="${empty countries}">
    <h3>Sorry, no records found</h3>
</c:if>
<c:forEach items="${countries}" var="country">
    <c:out value="${country.id}" />
    <c:out value="${country.countryName}" />
    <c:out value="${country.continent}" />
    <br/>


    <a href="/delete/${country.id}">Delete</a>
    <a href="/country/edit-form/${country.id}">Edit</a>
    <a href="/city/edit-form/${country.id}">Add city</a>
    <br/><br/><br/>
</c:forEach>

</body>
</html>