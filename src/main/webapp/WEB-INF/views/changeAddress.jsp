
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="/css/style.css">

    <title>Change Address</title>
</head>
<body>
<%@include file="header.jsp" %>
<div style="background: whitesmoke;width: 900px;position: relative;left: 50px;">

<form:form modelAttribute="userAddress" method="post">
    <form:hidden path="userName" ></form:hidden>
    <form:hidden path="id"></form:hidden>
    Street: <form:input path="street"/><br/> <form:errors path="street"/><br/>
    Home Number: <form:input path="homeNumber"/><br/><form:errors path="homeNumber"/><br/>
    Flat Number: <form:input path="flatNumber"/><br/><form:errors path="flatNumber"/><br/>
    Postal Code: <form:input path="postalCode"/><br/><form:errors path="postalCode"/><br/>
    City: <form:input path="city"/><br/><form:errors path="city"/><br/>
    Voivodeship: <form:input path="voivodeship"/><br/><form:errors path="voivodeship"/><br/>
    Country: <form:input path="country"/><br/><form:errors path="country"/><br/>
    <input type="submit" value="Update Address">
</form:form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
