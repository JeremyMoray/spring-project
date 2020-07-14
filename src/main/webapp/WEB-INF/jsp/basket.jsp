<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <script>
        function init(){
            let infoColumns = document.getElementsByClassName("product-infos-basket");
            for(infoColumn of infoColumns){
                infoColumn.addEventListener('input', function (evt) {
                    showUpdateButton(evt);
                    updateTotalPrice();
                });
            }
        }
        window.onload = init;

        function updateTotalPrice(){
            let infoColumns = document.getElementsByClassName("product-infos-basket");
            let totalPrice = 0;
            for(infoColumn of infoColumns){
                totalPrice += parseFloat(infoColumn.getElementsByClassName("price-value")[0].innerHTML) * parseFloat(infoColumn.getElementsByClassName("quantity-value")[0].value);
            }
            document.getElementById("totalPrice").innerText = totalPrice.toString();
        }

        function showUpdateButton(evt) {
            let keyname = evt.target.id.replace('basket-input-','');
            document.getElementById("link-update-basket-" + keyname).style.visibility = "visible";
        }

        function reloadQuantity(event){
            let keyname = event.id.replace('link-update-basket-','');
            let quantity = document.getElementById("basket-input-" + keyname).value;

            window.location.href = ("/basket/update?keyname=" + keyname + "&quantity=" + quantity);
        }
    </script>
</head>
<body>
    <div class="main-container">
        <h2 class="h2-subtitle"><spring:message code="basket" /></h2>
        <hr>
        <c:set var = "totalPrice" scope = "page" value = "0"/>
        <c:forEach items="${ translationProducts }" var="item" varStatus="status">
            <div class="row">
                <div class="col-md-2">
                    <img class="img-details" src='<c:url value="${ item.key.product.imageURL }" />' />
                </div>
                <div class="col-md-8 basket-product-description">
                    <h5><c:out value="${ item.key.name }" /></h5>
                    <p><c:out value="${ item.key.description }" /></p>
                </div>
                <div class="col-md-2 product-infos-basket">
                    <p class="basket-price"><span style="color: black;"><spring:message code="price" /> :</span> <span class="price-value"><c:out value="${ item.key.product.unitPrice }" /></span> €</p>
                    <p>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1"><spring:message code="quantity" /> : </span>
                            </div>
                            <input id="basket-input-${ item.key.product.keyname }" type="number" class="form-control quantity-value" min="1" value="<c:out value="${ item.value }" />" />
                        </div>
                    </p>
                    <p>
                        <div>
                            <a id="link-update-basket-${ item.key.product.keyname }" class="font-apple link-update-basket" onclick="reloadQuantity(this)" href="#"><spring:message code="update" /></a>
                            <a class="font-apple link-delete-basket" href="<c:url value="/basket/delete?keyname=${ item.key.product.keyname }" />"><spring:message code="delete" /></a>
                        </div>
                    </p>
                    <c:set var="totalPrice" scope="page" value="${ totalPrice + item.value * item.key.product.unitPrice }" />
                </div>
            </div>
            <hr>
        </c:forEach>
        <p class="basket-total-price"><span style="color: black;"><spring:message code="totalPrice" /> : </span><span id="totalPrice"><c:out value="${ totalPrice }" /></span> €</p>
        <p class="text-center">
            <button type="button" class="button-order-basket font-apple" onclick="window.location.href='<c:url value="/order/confirmation" />'"><spring:message code="order" /></button>
        </p>
    </div>
</body>
</html>
