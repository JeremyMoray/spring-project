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
    <a <c:if test="${currentPage == 'products'}">class="active"</c:if> href="<c:url value="/products" />">Products</a>
    <a <c:if test="${currentPage == 'about'}">class="active"</c:if> href="<c:url value="/about" />">About</a>
    <a class="<c:if test="${currentPage == 'basket'}">active</c:if> basket-menu" href="<c:url value="/basket" />">Basket</a>
</div>
<tiles:insertAttribute name = "main-content" />
</body>
</html>