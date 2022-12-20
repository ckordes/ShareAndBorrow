
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">

    <title>Register Yourself!</title>
</head>
<body>
<%@include file="header.jsp" %>
<div style="background: whitesmoke;width: 900px;position: relative;left: 50px;">

<h2> <c:out value="${error}"></c:out></h2>

<form:form action="/register" method="post" modelAttribute="userRegister">
First Name: <form:input path="firstName"/><br/>
    <form:errors path="firstName"/><br/>
Last Name: <form:input path="lastName"/><br/>
    <form:errors path="lastName"/><br/>
PESEL: <form:input path="pesel"/><br/>
    <form:errors path="pesel"/><br/>
E-mail: <form:input path="email"/><br/>
    <form:errors path="email"/><br/>
User name: <form:input path="username"/><br/>
    <form:errors path="username"/><br/>
Password:<form:input path="password" type="password"/><br/>
    <form:errors path="password"/><br/>
<div>
    Repeat password: <input type="password" name="password2" placeholder="Repeat Password."/><br/>
</div>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <input name ="submit" type="submit" value="Register Me!">
</form:form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>