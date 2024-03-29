
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="/css/style.css">

    <title>Search Tool</title>
</head>
<body>
<%@include file="header.jsp" %>
<br/>
<div style="background: whitesmoke;width: 900px;position: relative;left: 50px;">

<form:form method="post" modelAttribute="toolTypePostalCode">
    <form:select path="toolType" multiple="false">
        <c:forEach items="${ToolTypeList}" var="toolTypeFromList">
            <option value=${toolTypeFromList.id}>${toolTypeFromList.type}</option>
        </c:forEach>
    </form:select></br>
    Type in postal code: <form:input  path="postalCode"/>

</br>
    <input type="submit" value="Search Tools">
</form:form>

</br>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
