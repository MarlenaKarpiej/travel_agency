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

<c:if test="${empty trips}">
    <h3>Sorry, no records found</h3>
</c:if>
<c:forEach items="${trips}" var="trip">
<fieldset>    <c:out value="${trip.id}"/><br/>
    Departure from: <c:out value="${trip.fromAirport.airportName}"/><br/>
    Departure date: <c:out value="${trip.flyOut}"/><br/>
    Arrival at: <c:out value="${trip.toAirport.airportName}"/><br/>
    Arrival date: <c:out value="${trip.flyBack}"/><br/>
    Hotel: <c:out value="${trip.hotel.hotelName}"/><br/>
    Number of days: <c:out value="${trip.getNumberOfDays()}"/><br/>
    Price for adult: <c:out value="${trip.adultPrice}"/><br/>
    Price for child:<c:out value="${trip.childPrice}"/><br/>
    Meals type: <c:out value="${trip.mealsType}"/><br/>
    Seats number: <c:out value="${trip.seatsNumber}"/><br/>
    Promoted: <c:out value="${trip.promoted}"/><br/>

    <a href="/admin/trip/delete/${trip.id}">Delete trip</a>
    <a href="/admin/trip/edit/${trip.id}">Edit trip</a>
    </fieldset>
    <br/><br/><br/>
</c:forEach>

</body>
</html>