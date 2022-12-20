
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="/css/style.css">

    <title>Add Tool</title>
</head>
<body>
<%@include file="header.jsp" %>
<div style="background: whitesmoke;width: 900px;position: relative;left: 50px;">
<form:form modelAttribute="addTool" method="post">
    Type: <form:select path="toolType" multiple="false" items="${ToolTypeList}" itemValue="id" itemLabel="type" /><br/> <form:errors path="toolType"/><br/>
    Name: <form:input path="name"/><br/> <form:errors path="name"/><br/>
    Description: <form:input path="description"/><br/> <form:errors path="description"/><br/>
    <input type="submit" value="Add Tool">
</form:form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>