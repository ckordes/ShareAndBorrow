
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="/css/style.css">

    <title>Your's Address</title>
</head>
<body>
<%@include file="header.jsp" %>
<div style="background: whitesmoke;width: 900px;position: relative;left: 50px;">

<form:form method="post" modelAttribute="addressRegister" action="/address">
    Street: <form:input path="street"/><br/>
    <form:errors path="street"/><br/>
    Home number: <form:input path="homeNumber"/><br/>
    <form:errors path="homeNumber"/><br/>
    Flat number: <form:input path="flatNumber"/><br/>
    <form:errors path="flatNumber"/><br/>
    City: <form:input path="city"/><br/>
    <form:errors path="city"/><br/>
    Postal Code: <form:input path="postalCode"/><br/>
    <form:errors path="postalCode"/><br/>
    Voievodyship:<form:input path="voivodeship"/><br/>
    <form:errors path="voivodeship"/><br/>
    Country:<form:input path="country"/><br/>
    <form:errors path="country"/><br/>
    <input name ="submit" type="submit" value="Register Address!">
</form:form>

</div>
<%@include file="footer.jsp" %>
</body>
</html>
