<%--
  Created by IntelliJ IDEA.
  User: baltazarw
  Date: 21.12.2020
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Change User Information</title>
</head>
<body>
<%@include file="header.jsp" %>

<form:form modelAttribute="userCredentialsModifications" method="post">
    E-mail: <form:input path="email"/><br/> <form:errors path="email"/><br/>
    Password: <form:input path="password"/><br/><form:errors path="password"/><br/>
    Confirm Password: <form:input path="password2"/><br/><form:errors path="password2"/><br/>
    <h3> ${errorMsg} </h3>
    <input type="submit" value="Update Data">
</form:form>
<%@include file="footer.jsp" %>
</body>
</html>
