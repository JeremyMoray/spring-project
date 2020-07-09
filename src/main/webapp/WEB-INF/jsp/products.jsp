<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <div class="row">
            <div class="col">
                <h2 class="h2-subtitle"><spring:message code="products" /></h2>
            </div>
            <div class="col">
                <button type="button" class="button-back font-apple" onclick="window.location.href='<c:url value="/catalog" />'">< <spring:message code="catalog" /></button>
            </div>
        </div>
        <c:forEach items="${ translationProducts }" var="translationProduct" varStatus="status">

            <c:if test="${status.count%3 == 1}">
                <div class="row">
            </c:if>

            <div class="col-md-4">
                <button class="button-category font-apple">
                    <c:out value="${ translationProduct.name }" />
                </button>
            </div>

            <c:if test="${status.count%3 == 0}">
                </div>
            </c:if>

        </c:forEach>
    </div>
</body>
</html>
