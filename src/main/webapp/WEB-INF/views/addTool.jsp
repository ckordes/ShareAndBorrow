<%--
  Created by IntelliJ IDEA.
  User: baltazarw
  Date: 14.03.2021
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: baltazarw
  Date: 29.12.2020
  Time: 09:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Tool</title>
</head>
<body>
<%@include file="header.jsp" %>
<form:form modelAttribute="addTool" method="post">
    Type: <form:select path="toolType" multiple="false" items="ToolTypeList" itemValue="id" itemLabel="type" /><br/> <form:errors path="toolType"/><br/>
    Name: <form:input path="name"/><br/> <form:errors path="name"/><br/>
    <input type="submit" value="Add Tool">
</form:form>
<%@include file="footer.jsp" %>
</body>
</html>