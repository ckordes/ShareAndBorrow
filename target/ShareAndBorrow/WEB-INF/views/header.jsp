<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header">
    <div style="background: olivedrab;width: 900px;position: relative;left: 50px;">
    <h1>Share and Borrow</h1>
    </div>
<div style="background: azure;width: 900px;position: relative;left: 50px;">
    <p>
        <br>
    <sec:authorize access="!isAuthenticated()">
        <a href="/login" style="background: aquamarine">Log In</a>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <a href="/register" style="background: aquamarine">Register</a>
    </sec:authorize>
    <sec:authorize access="hasRole('USER')">

<%--        update of link needed--%>
        <a href="/user/userZone" style="background: aquamarine">User Zone</a>
        <a href="/user/toolsManagement" style="background: aquamarine">Tools Management</a>

    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">

<%--        update of link needed--%>
        <a href="/admin/mainPage" style="background: aquamarine">Admin Zone</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <p>Logged in as: <sec:authentication property="principal.username"/></p>

        <form action="<c:url value="/logout"/>" method="post">
            <input type="submit" value="Log Out">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <%--        update of link needed--%>
<%--        <a href="/user/addTool" style="background: aquamarine">Add Your Tool</a>--%>
        <a href="/user/changePassword" style="background: aquamarine">Change E-mail or Password</a>
        <a href="/user/changeAddress" style="background: aquamarine">Change Address</a>
    </sec:authorize><br><br>
    </p>
</div>
</header>