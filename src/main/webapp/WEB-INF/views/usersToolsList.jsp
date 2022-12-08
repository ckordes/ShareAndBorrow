

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="/css/style.css">

    <title>Tools List</title>
</head>
<body class="container">
<%@include file="header.jsp" %>

<h5>List of users you are looking for!</h5>
<table>
    <col width="300">
    <col width="200">
    <col width="300">
    <col width="200">
    <tr>
        <th><h4>User Name</h4></th>
        <th><h4>Street Name</h4></th>
        <th><h4>Home Number</h4></th>
        <th><h4>Tools Type</h4></th>
    </tr>
    <c:forEach items="${usersToolsList}" var="userToolsTypes">
        <tr>
            <td>
                    ${userToolsTypes.username}
            </td>
            <td>
                    ${userToolsTypes.address.street}
            </td>
            <td>
                    ${userToolsTypes.address.homeNumber}
            </td>

            <td>
                <c:forEach items="${userToolsTypes.tools}" var="tool">
                    ${tool.toolType.type}<br>
                </c:forEach>
            </td>

        </tr>
    </c:forEach>
<%--        <tr>--%>
<%--            <c:forEach items="${userToolsTypes.tools}" var="tool">--%>
<%--                ${tool.tooltype.type}<br>--%>
<%--            </c:forEach>--%>
<%--        </tr>--%>

</table>

<%@include file="footer.jsp" %>
</body>
</html>
