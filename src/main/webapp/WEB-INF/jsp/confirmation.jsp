<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <button type="button" class="button-order-basket font-apple" onclick="window.location.href='<c:url value="/order/validation" />'"><spring:message code="confirm" /></button>
    </div>
</body>
</html>
