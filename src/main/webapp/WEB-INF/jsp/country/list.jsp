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
    <c:out value="${country.id}"/>
    <c:out value="${country.countryName}"/>
    <c:out value="${country.continent}"/>
    <a href="/country/delete/${country.id}">Delete country</a>
    <a href="/country/edit/${country.id}">Edit country</a>
    <a href="/city/create/${country.id}">Add city</a><br/><br/>

    <c:forEach items="${country.cities}" var="city">
        <c:out value="${city.id}"/>
        <c:out value="${city.cityName}"/>

        <a href="/city/delete-city/${city.id}">Delete city</a>
        <a href="/city/edit-city/${city.id}/${country.id}">Edit city</a>
        <a href="/hotel/create/${city.id}">Add hotel</a>
        <br/>

        <c:forEach items="${city.hotels}" var="hotel">
            <c:out value="${hotel.id}"/>
            Name: <c:out value="${hotel.hotelName}"/><br/>
            Property class: <c:out value="${hotel.propertyClass}"/><br/>
            Description: <c:out value="${hotel.description}"/><br/>

            <a href="/hotel/delete-hotel/${hotel.id}">Delete hotel</a>
            <a href="/hotel/edit-hotel/${hotel.id}/${city.id}">Edit hotel</a>

            <br/><br/>
        </c:forEach>
    </c:forEach>



    <br/><br/><br/>
</c:forEach>

</body>
</html>