<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title>${title}</title>
    <link type="text/css" href="<spring:url value='/css/first.css' />" rel="stylesheet">
</head>
<body>
<header>
    <h1>Green garden</h1>
</header>
<tiles:insertAttribute name = "main-content" />
<footer>
    By Jérémy Moray
</footer>
</body>
</html>