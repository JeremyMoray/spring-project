<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link type="text/css" href="<spring:url value='/css/first.css' />" rel="stylesheet">
</head>
<body>
    <header>
        <div id="header-container">
            <h1>Green garden</h1>
        </div>
    </header>

    <div class="topnav">
        <a class="<c:if test="${currentPage == 'home'}">active</c:if> first-menu" href="<c:url value="/home" />">Home</a>
        <a class="<c:if test="${currentPage == 'products'}">active</c:if>" href="<c:url value="/products" />">Products</a>
        <a class="<c:if test="${currentPage == 'about'}">active</c:if>" href="<c:url value="/about" />">About</a>
        <a class="<c:if test="${currentPage == 'basket'}">active</c:if> basket-menu" href="<c:url value="/basket" />">Basket</a>
    </div>

    <c:if test="${currentPage != 'login' && currentPage != 'register'}">
        <div class="profile-container">
            <div class="row">
                <div class="col-sm header-text">
                    <sec:authorize access="isAuthenticated()">
                        <h2>Welcome <sec:authentication property="principal.username" /> !</h2>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <h2>Login or register here</h2>
                    </sec:authorize>
                </div>
                <div class="col-sm button-auth">
                    <sec:authorize access="isAuthenticated()">
                        <button class="button button-logout font-apple" onclick="window.location.href='<c:url value="/logout" />'">Logout</button>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <button class="button button-login font-apple" onclick="window.location.href='<c:url value="/login" />'">Login</button>
                        <button class="button button-register font-apple" onclick="window.location.href='<c:url value="/register" />'">Register</button>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </c:if>

    <tiles:insertAttribute name = "main-content" />
</body>
</html>