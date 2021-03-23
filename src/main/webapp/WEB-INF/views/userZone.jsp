<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazarw
  Date: 17.03.2021
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Zone</title>
</head>
<body>
<%@include file="header.jsp" %>
<br/>
<a href="/user/addTool" style="background: aquamarine">Add New Tool</a>


<h5>List of all tools</h5>
<table>
    <col width="120">
    <col width="200">
    <col width="500">
    <col width="70">
    <col width="70">
    <tr>
        <td><h4>Tool Type</h4></td>
        <td><h4>Name</h4></td>
        <td><h4>Description</h4></td>
        <td><h4>Edit</h4></td>
        <td><h4>Delete</h4></td>
    </tr>
    <c:forEach items="${toolList}" var="tool">
        <tr>
            <td>
                    ${tool.toolType.type}
            </td>
            <td>
                    ${tool.name}
            </td>
            <td>
                    ${tool.description}
            </td>
            <td>
                <a href="editTool/${tool.id}">Edit</a>
            </td>
            <td>
                <a href="deleteTool/${tool.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
<br/>
<%@include file="footer.jsp" %>

</body>
</html>
