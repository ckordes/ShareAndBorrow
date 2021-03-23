<%--
  Created by IntelliJ IDEA.
  User: baltazarw
  Date: 23.03.2021
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Tool</title>
</head>
<body>
<%@include file="header.jsp" %>

<form:form modelAttribute="tool" method="post">
    <form:hidden path="id"/>
    <form:hidden path="userID"/>
    Type: <form:select path="toolType" multiple="false" items="${ToolTypeList}" itemValue="id" itemLabel="type" /><br/> <form:errors path="toolType"/><br/>
    Name: <form:input path="name"/><br/> <form:errors path="name"/><br/>
    Description: <form:input path="description"/><br/> <form:errors path="description"/><br/>
    <input type="submit" value="Save Changes">
</form:form>

<%@include file="footer.jsp" %>

</body>
</html>
