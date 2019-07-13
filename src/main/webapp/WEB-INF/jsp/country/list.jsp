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
    <a href="/admin/country/delete/${country.id}">Delete country</a>
    <a href="/admin/country/edit/${country.id}">Edit country</a>
    <a href="/admin/city/create/${country.id}">Add city</a><br/><br/>

    <c:forEach items="${country.cities}" var="city">
        <c:out value="${city.id}"/>
        <c:out value="${city.cityName}"/>

        <a href="/admin/city/delete-city/${city.id}">Delete city</a>
        <a href="/admin/city/edit-city/${city.id}/${country.id}">Edit city</a>
        <a href="/admin/hotel/create/${city.id}">Add hotel</a>
        <a href="/admin/airport/create/${city.id}">Add airport</a>
        <br/>

        <c:forEach items="${city.hotels}" var="hotel">
            <c:out value="${hotel.id}"/>
            Hotel name: <c:out value="${hotel.hotelName}"/><br/>
            Star Rating: <c:out value="${hotel.starRating}"/><br/>
            Description: <c:out value="${hotel.description}"/><br/>

            <a href="/admin/hotel/delete-hotel/${hotel.id}">Delete hotel</a>
            <a href="/admin/hotel/edit-hotel/${hotel.id}/${city.id}">Edit hotel</a>

            <br/><br/>
        </c:forEach>
        <c:forEach items="${city.airports}" var="airport">
            <c:out value="${airport.id}"/>
            Airport name: <c:out value="${airport.airportName}"/><br/>

            <a href="/admin/airport/delete-airport/${airport.id}">Delete airport</a>
            <a href="/admin/airport/edit-airport/${airport.id}/${airport.id}">Edit airport</a>

            <br/><br/>
        </c:forEach>
    </c:forEach>

    <br/><br/><br/>
</c:forEach>

</body>
</html>