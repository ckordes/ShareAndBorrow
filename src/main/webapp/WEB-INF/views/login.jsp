<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 05.02.2020
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<%@include file="header.jsp" %>

<form method="post">
    <div><label> User Name : <input type="text" name="email"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<%@include file="footer.jsp" %>

</body>
</html>
