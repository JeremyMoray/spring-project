<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <div class="row">
            <div class="col">
                <h2 class="h2-subtitle">${ categoryName }</h2>
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
                <img class="img-product" src='<c:url value="${ translationProduct.product.imageURL }" />' onclick="window.location.href='<c:url value="/catalog/${ translationProduct.product.category.keyname }/${ translationProduct.product.keyname }" />'"/>
                <button class="button-product font-apple" onclick="window.location.href='<c:url value="/catalog/${ translationProduct.product.category.keyname }/${ translationProduct.product.keyname }" />'">
                    <c:if test="${ translationProduct.product.unitPrice != realPrices.get(status.count - 1) }">
                        ${ translationProduct.name } - ${ realPrices.get(status.count - 1) } € <small class="text-danger font-weight-bold"><s>${ translationProduct.product.unitPrice } €</s></small>
                    </c:if>
                    <c:if test="${ translationProduct.product.unitPrice == realPrices.get(status.count - 1) }">
                        <c:out value="${ translationProduct.name } - ${ translationProduct.product.unitPrice } €" />
                    </c:if>
                </button>
            </div>

            <c:if test="${status.count%3 == 0}">
                </div>
            </c:if>

        </c:forEach>
    </div>
</body>
</html>
