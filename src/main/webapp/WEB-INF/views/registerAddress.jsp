<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 17.04.2020
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your's Address</title>
</head>
<body>
<%@include file="header.jsp" %>

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
    Voievodyship:<form:input path="voievodyship"/><br/>
    <form:errors path="voievodyship"/><br/>
    Country:<form:input path="country"/><br/>
    <form:errors path="country"/><br/>
    <input name ="submit" type="submit" value="Register Address!">
</form:form>


<%@include file="footer.jsp" %>
</body>
</html>
