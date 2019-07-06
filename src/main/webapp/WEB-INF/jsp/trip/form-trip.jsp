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
<h2>Create trip form</h2>
<form:form action="/admin/trip/create" method="POST" modelAttribute="newTrip">

    <%--Fly out airport:--%>
    <%--<form:select path="airportFlyOut">--%>
        <%--<form:option value="" label="Please Select"/>--%>
        <%--<form:options items="${airport.airportName}"/>--%>
    <%--</form:select>--%>

    <%--Fly in airport:--%>
    <%--<form:select path="airportFlyIn">--%>
        <%--<form:option value="" label="Please Select"/>--%>
        <%--<form:options items="${airport.airportName}"/>--%>
    <%--</form:select>--%>

    <%--Hotel name:--%>
    <%--<form:select path="hotel">--%>
        <%--<form:option value="" label="Please Select"/>--%>
        <%--<form:options items="${airport.airportName}"/>--%>
    <%--</form:select>--%>

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

    <%--Continent:--%>
    <%--<form:select path="continent">--%>
        <%--<form:option value="" label="Please Select"/>--%>
        <%--<form:options items="${enumValues}"/>--%>
    <%--</form:select>--%>
    <%--<br/>--%>

    <%--<input type="submit" value="Create"/>--%>
</form:form>
</body>
</html>