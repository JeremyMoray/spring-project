<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <h2 class="h2-subtitle">Login</h2>

        <sec:authorize access="!isAuthenticated()">
            <form:form id="user" method="POST" modelAttribute="userForm">
                <p>
                    <form:label path="username">Login</form:label>
                    <form:input path="username"></form:input>
                    <form:errors path="username" />
                </p>

                <p>
                    <form:label path="password">Password</form:label>
                    <form:input path="password"></form:input>
                    <form:errors path="password" />
                </p>
                <p>
                    <form:button>Send</form:button>
                </p>
            </form:form>
        </sec:authorize>
    </div>
</body>
</html>
