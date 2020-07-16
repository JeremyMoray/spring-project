<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="type=test/html; charset=utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link type="text/css" href="<spring:url value='/css/first.css' />" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <title>${title}</title>
</head>
<body>
    <header>
        <div id="header-container">
            <h1>Green garden</h1>
        </div>
    </header>

    <c:set var="basketSize" value="${fn:length(basket)}"/>
    <div class="topnav">
        <a class="<c:if test="${currentPage == 'home'}">active</c:if> first-menu" href="<c:url value="/home" />">
            <spring:message code="home" />
        </a>
        <a class="<c:if test="${currentPage == 'catalog'}">active</c:if>" href="<c:url value="/catalog" />">
            <spring:message code="catalog" />
        </a>
        <a class="<c:if test="${currentPage == 'about'}">active</c:if>" href="<c:url value="/about" />">
            <spring:message code="about" />
        </a>
        <a class="<c:if test="${currentPage == 'basket'}">active</c:if> basket-menu" href="<c:url value="/basket" />">
            <spring:message code="basket" /> (${basketSize})
        </a>
    </div>

    <div class="locale-container">
        <spring:url var="localeFr" value="">
            <spring:param name="locale" value="fr" />
        </spring:url>
        <spring:url var="localeEn" value="">
            <spring:param name="locale" value="en" />
        </spring:url>

        <a href="${localeFr}"><img src="<spring:url value="/images/flagFr.png"/>" alt="fr" width="50" height="50"/></a>
        <a href="${localeEn}"><img src="<spring:url value="/images/flagEn.png"/>" alt="en" width="50" height="50"/></a>
    </div>

    <c:if test="${currentPage != 'login' && currentPage != 'register'}">
        <div class="profile-container">
            <div class="row">
                <div class="col-sm header-text">
                    <sec:authorize access="isAuthenticated()">
                        <h2><spring:message code="welcome" /> <sec:authentication property="principal.username" /> !</h2>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <h2><spring:message code="loginOrRegisterHere" /></h2>
                    </sec:authorize>
                </div>
                <div class="col-sm button-auth">
                    <sec:authorize access="isAuthenticated()">
                        <button class="button button-logout font-apple" onclick="window.location.href='<c:url value="/logout" />'"><spring:message code="logout" /></button>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <button class="button button-login font-apple" onclick="window.location.href='<c:url value="/login" />'"><spring:message code="login" /></button>
                        <button class="button button-register font-apple" onclick="window.location.href='<c:url value="/register" />'"><spring:message code="register" /></button>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </c:if>

    <tiles:insertAttribute name = "main-content" />
</body>
</html>