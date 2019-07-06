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

<c:if test="${empty trip}">
    <h3>Sorry, no records found</h3>
</c:if>
<c:forEach items="${trips}" var="trip">
    <c:out value="${trip.id}"/>

    <a href="/admin/trip/delete/${trip.id}">Delete trip</a>
    <a href="/admin/trip/edit/${trip.id}">Edit trip</a>

    <br/><br/><br/>
</c:forEach>

</body>
</html>