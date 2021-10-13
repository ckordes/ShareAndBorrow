
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="/css/style.css">

    <title>Change User Information</title>
</head>
<body>
<%@include file="header.jsp" %>
<div style="background: whitesmoke;width: 900px;position: relative;left: 50px;">

<form:form modelAttribute="userCredentialsModifications" method="post">
    E-mail: <form:input path="email"/><br/> <form:errors path="email"/><br/>
    Password: <form:input path="password"/><br/><form:errors path="password"/><br/>
    Confirm Password: <form:input path="password2"/><br/><form:errors path="password2"/><br/>
    <h3> ${errorMsg} </h3>
    <input type="submit" value="Update Data">
</form:form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
