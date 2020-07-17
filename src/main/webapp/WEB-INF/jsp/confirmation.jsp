<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <script>
        function init(){
            let totalPrice = document.getElementById('totalPrice');
            totalPrice.innerText = (Math.round(parseFloat(totalPrice.innerText) * 100) / 100).toFixed(2);
        }
        window.onload = init;
    </script>
</head>
<body>
    <div class="main-container">
        <h2 class="h2-subtitle"><spring:message code="confirmation" /></h2>
        <div class="confirmation-container">
            <div class="row">
                <div class="col-md-8">
                    <p><spring:message code="products" /></p>
                </div>
                <div class="col-md-2 text-right">
                    <p><spring:message code="quantity" /></p>
                </div>
                <div class="col-md-2 text-right">
                    <p><spring:message code="price" /></p>
                </div>
            </div>
            <hr>
            <c:set var = "totalPrice" scope = "page" value = "0"/>
            <c:forEach items="${ translationProducts }" var="item" varStatus="status">
                <div class="row">
                    <div class="col-md-8">
                        <p><c:out value="${ item.key.name }" /></p>
                    </div>
                    <div class="col-md-2 text-right">
                        <p><c:out value="${ item.value }" /></p>
                    </div>
                    <div class="col-md-2 text-right">
                        <p><c:out value="${ item.key.product.unitPrice }" /> €</p>
                        <c:set var="totalPrice" scope="page" value="${ totalPrice + item.value * item.key.product.unitPrice }" />
                    </div>
                </div>
            </c:forEach>
            <hr>
            <p class="text-right">
                <spring:message code="totalPrice" /> : <span id="totalPrice"><c:out value="${ totalPrice }" /></span> €
            </p>
            <p class="text-center">
                <button type="button" class="button-confirm-basket font-apple" onclick="window.location.href='<c:url value="/order/validation" />'"><spring:message code="confirm" /></button>
            </p>
        </div>
    </div>
</body>
</html>
