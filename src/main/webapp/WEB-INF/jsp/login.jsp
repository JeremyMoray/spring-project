<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <sec:authorize access="!isAuthenticated()">
        <div class="main-container login-container">
            <div class="login-form">
                <h2 class="h2-subtitle"><spring:message code="logIn" /></h2>
                    <form:form id="userLoginForm" method="POST" modelAttribute="userForm">

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><spring:message code="username" /></span>
                            </div>
                            <form:input path="username" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></form:input>
                            <form:errors path="username" />
                        </div>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><spring:message code="password" /></span>
                            </div>
                            <form:input path="password" type="password" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></form:input>
                            <form:errors path="password" />
                        </div>

                        <div>
                            <form:button class="button-form-login font-apple"><spring:message code="logIn" /></form:button>
                            <button type="button" class="button-form-login button-form-register font-apple" onclick="window.location.href='<c:url value="/register" />'"><spring:message code="register" /></button>
                        </div>

                    </form:form>
            </div>
        </div>
    </sec:authorize>
</body>
</html>
