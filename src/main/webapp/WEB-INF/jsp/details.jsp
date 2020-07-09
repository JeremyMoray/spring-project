<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <div class="row text-right">
            <div class="col">
                <button type="button" class="button-back font-apple" onclick="window.location.href='<c:url value="/catalog" />'">< <spring:message code="catalog" /></button>
            </div>
        </div>
        <div class="row details-container">
            <div class="col-5">
                <img class="img-details" src='<c:url value="${ translationProduct.product.imageURL }" />' />
            </div>
            <div class="col-5">
                <h2 class="h2-subtitle">${ translationProduct.name }</h2>
                <p>${ translationProduct.description }</p>
            </div>
            <div class="col-2">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1"><spring:message code="quantity" /> : </span>
                    </div>
                    <input type="number" class="form-control" aria-label="Quantity" min="1" placeholder="1">
                </div>
                <button type="button" class="button-add-basket font-apple" onclick="window.location.href='<c:url value="#" />'"><spring:message code="addToBasket" /></button>
            </div>
        </div>
    </div>
</body>
</html>
