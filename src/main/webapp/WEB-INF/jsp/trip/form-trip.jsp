<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>--%>
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
<h3>Create trip form</h3>
<form:form action="/admin/trip/create" method="POST" modelAttribute="newTrip">

    Departure from:
    <select name="fromAirport">
        <c:forEach items="${airports}" var="airport">
            <c:set var="selected" value=""/>
            <option value="${airport.id}" ${selected}>${airport.airportName}</option>
        </c:forEach>
    </select><br/>
    Departure date:<form:input path="flyOut" type="date" /><br />
    Arrival at:
    <select name="toAirport">
        <c:forEach items="${airports}" var="airport">
            <c:set var="selected" value=""/>
            <option value="${airport.id}" ${selected}>${airport.airportName}</option>
        </c:forEach>
    </select><br/>
    Arrival date:<form:input path="flyBack" type="date" /><br />
    Hotel :
    <select name="hotel">
        <c:forEach items="${hotels}" var="hotel">
            <c:set var="selected" value=""/>
            <option value="${hotel.id}" ${selected}>${hotel.hotelName}</option>
        </c:forEach>
    </select><br/>

    Price for adult: <form:input path="adultPrice"/> <br />
    Price for child: <form:input path="childPrice"/> <br />
    Meals type: <form:input path="mealsType"/> <br />
    Seats number: <form:input path="SeatsNumber"/> <br />
    Promoted: <form:input path="promoted"/> <br />





    <input type="submit" value="Create"/>
</form:form>
</body>
</html>