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
<h3>Edit trip form</h3>
<form:form action="/admin/trip/edit/${tripId}" method="POST" modelAttribute="trip">

    Departure from:
    <form:select path="fromAirport">
        <form:options items="${airports}" itemValue="id" itemLabel="airportName"></form:options>
    </form:select><br/>
    Departure date:<form:input path="flyOut" value="${flyOut}" type="date" /><br />
    Arrival at:
    <form:select path="toAirport">
        <form:options items="${airports}" itemValue="id" itemLabel="airportName"></form:options>
    </form:select><br/>
    Arrival date:<form:input path="flyBack" value="${flyBack}" type="date" /><br />
    Hotel :
    <form:select path="hotel">
        <form:options items="${hotels}" itemValue="id" itemLabel="hotelName"></form:options>
    </form:select><br/>
    Price for adult: <form:input path="adultPrice"/> <br />
    Price for child: <form:input path="childPrice"/> <br />
    Meals type:
    <form:select path="mealsType">
        <form:option value="" label="Please Select"/>
        <form:options items="${enumValues}"/>
    </form:select>
    <br/>
    Seats number <form:input path="SeatsNumber"/> <br />
    Promoted: <form:input path="promoted"/> <br />




    <%--<form:hidden path="id" />--%>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>