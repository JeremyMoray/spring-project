<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <h2 class="h2-subtitle"><spring:message code="catalog" /></h2>
        <c:forEach items="${ translationCategories }" var="translationCategory" varStatus="status">

            <c:if test="${status.count%3 == 1}">
                <div class="row">
            </c:if>

                <div class="col-md-4">
                    <button class="button-category font-apple" onclick="window.location.href='<c:url value="/catalog/${ translationCategory.category.keyname }" />'">
                        <c:out value="${ translationCategory.name }" />
                    </button>
                </div>

            <c:if test="${status.count%3 == 0}">
                </div>
            </c:if>

        </c:forEach>
    </div>
</body>
</html>
