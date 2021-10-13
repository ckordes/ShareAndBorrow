
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="/css/style.css">

    <title>Login Page</title>
</head>
<body>

<%@include file="header.jsp" %>
<div style="background: whitesmoke;width: 900px;position: relative;left: 50px;">

<form method="post" action="/login">
    <div><label> User Name : <input type="text" name="username" id="username"/> </label></div>
    <div><label> Password: <input type="password" name="password" id="password"/> </label></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div><input name="submit" type="submit" value="Sign In"/></div>

</form>
</div>
<%@include file="footer.jsp" %>

</body>
</html>
