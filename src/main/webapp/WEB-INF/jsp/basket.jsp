<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>

</head>
<body>
    <div class="main-container">
        <c:forEach items="${ translationProducts }" var="item" varStatus="status">
            <p><c:out value="${ item.key.name }" /> : <c:out value="${ item.value }" /></p>
        </c:forEach>
    </div>
</body>
</html>
