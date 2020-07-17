<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <script>
        function changeURL(category, product){

            console.log(category);
            let url = "/catalog/" + category + "/" + product + "/add/" + document.getElementById("quantity-input").value;
            window.location.href = url;
        }
    </script>
</head>
<body>
    <div class="main-container">
        <div class="row">
            <div class="col">
                <h2 class="h2-subtitle">${ category.name }</h2>
            </div>
            <div class="col">
                <button type="button" class="button-back font-apple" onclick="window.location.href='<c:url value="/catalog/${ category.category.keyname }" />'">< ${ category.name }</button>
            </div>
        </div>
        <div class="row details-container">
            <div class="col-4">
                <img class="img-details" src='<c:url value="${ translationProduct.product.imageURL }" />' />
            </div>
            <div class="col-5">
                <h2 class="h2-subtitle">${ translationProduct.name } - ${ translationProduct.product.unitPrice } €</h2>
                <p>${ translationProduct.description }</p>
            </div>
            <div class="col-3">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1"><spring:message code="quantity" /> : </span>
                    </div>
                    <input id="quantity-input" type="number" class="form-control" aria-label="Quantity" min="1" value="1">
                </div>
                <button id="button-add-basket" type="button" class="button-add-basket font-apple" onclick="changeURL('${ translationProduct.product.category.keyname }', '${ translationProduct.product.keyname }');"><spring:message code="addToBasket" /></button>
            </div>
        </div>
    </div>
</body>
</html>
