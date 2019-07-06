<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

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

    Arrival at:
    <select name="toAirport">
        <c:forEach items="${airports}" var="airport">
            <c:set var="selected" value=""/>
            <option value="${airport.id}" ${selected}>${airport.airportName}</option>
        </c:forEach>
    </select><br/>

    Hotel :
    <select name="hotel">
        <c:forEach items="${hotels}" var="hotel">
            <c:set var="selected" value=""/>
            <option value="${hotel.id}" ${selected}>${hotel.hotelName}</option>
        </c:forEach>
    </select><br/>

    <%--Departure date:--%>
    <%--<s:form id="form" theme="xhtml">--%>
        <%--<sj:datepicker id="date0" label="Select a Date"/>--%>
        <%--<sj:datepicker value="today" id="date" name="date" displayFormat="dd.mm.yy" label="Today"/>--%>
    <%--</s:form>--%>

    <%--Arrival date:--%>
    <%--<s:form id="form" theme="xhtml">--%>
        <%--<sj:datepicker id="date0" label="Select a Date"/>--%>
        <%--<sj:datepicker value="today" id="date" name="date" displayFormat="dd.mm.yy" label="Today"/>--%>
    <%--</s:form>--%>



    <input type="submit" value="Create"/>
</form:form>
</body>
</html>