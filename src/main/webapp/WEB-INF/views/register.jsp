<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 06.04.2020
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register Yourself!</title>
</head>
<body>
<%@include file="header.jsp" %>

<h2> <c:out value="${error}"></c:out></h2>

<form:form action="/register" method="post" modelAttribute="userRegister">
First Name: <form:input path="firstName"/>
    <form:errors path="firstName"/><br/>
Last Name: <form:input path="lastName"/>
    <form:errors path="lastName"/><br/>
PESEL: <form:input path="pesel"/>
    <form:errors path="pesel"/><br/>
E-mail: <form:input path="email"/>
    <form:errors path="email"/><br/>
User name: <form:input path="username"/>
    <form:errors path="username"/><br/>
Password:<form:input path="password"/>
    <form:errors path="password"/><br/>
<div>
    Repeat password: <input name="password2" placeholder="Repeat Password."/><br/>
</div>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <input name ="submit" type="submit" value="Register Me!">
</form:form>

<%@include file="footer.jsp" %>
</body>
</html>