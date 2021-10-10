<%--
  Created by IntelliJ IDEA.
  User: baltazarw
  Date: 04.05.2021
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Search Tool</title>
</head>
<body>
<%@include file="header.jsp" %>
<br/>
<div style="background: whitesmoke;width: 900px;position: relative;left: 50px;">

<form:form method="post" modelAttribute="toolType">
    <form:select path="type" multiple="false">
        <c:forEach items="${ToolTypeList}" var="toolTypeFromList">
            <option value=${toolTypeFromList.id}>${toolTypeFromList.type}</option>
        </c:forEach>
    </form:select></br>
    <form:form method="post" modelAttribute="postalCode">
        Type in postal code: <form:input path="blank" />
    </form:form>
</br>
    <input type="submit" value="Search Tools">
</form:form>

</br>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
