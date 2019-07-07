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
<h3>Edit hotel form</h3>
<form:form action="/admin/hotel/edit-hotel/${hotelId}/${cityId}" method="POST" modelAttribute="hotel">
    Hotel name: <form:input path="hotelName"/> <br />
    Star rating:
    <form:select path="starRating">
        <form:option value="" label="Please Select"/>
        <form:options items="${enumValues}"/>
    </form:select>
    <br/>
    Description: <form:input path="description"/> <br />
    <br/>
    <form:hidden path="id" />
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>