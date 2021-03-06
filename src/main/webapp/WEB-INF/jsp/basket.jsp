<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <script type="text/javascript" src="<spring:url value='/js/basket.js' />"></script>
</head>
<body>
    <div class="main-container">
        <h2 class="h2-subtitle"><spring:message code="basket" /></h2>
        <c:if test="${empty basket}"><spring:message code="emptyBasket" /></c:if>
        <c:if test="${not empty basket}">
            <hr>
            <c:set var = "totalPrice" scope = "page" value = "0"/>
            <c:forEach items="${ translationProducts }" var="item" varStatus="status">
                <div class="row">
                    <div class="col-md-2">
                        <img class="img-details" src='<c:url value="${ item.key.product.imageURL }" />' />
                    </div>
                    <div class="col-md-7 basket-product-description">
                        <h5><c:out value="${ item.key.name }" /></h5>
                        <p><c:out value="${ item.key.description }" /></p>
                    </div>
                    <div class="col-md-3 product-infos-basket">
                        <p class="basket-price"><span style="color: black;"><spring:message code="price" /> :</span> <span class="price-value"><c:out value="${ item.key.product.unitPrice }" /></span> €</p>
                        <p>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><spring:message code="quantity" /> : </span>
                                </div>
                                <input id="basket-input-${ item.key.product.keyname }" type="number" class="form-control quantity-value" min="1" value="<c:out value="${ item.value }" />" />
                            </div>
                        </p>
                        <p>
                            <div>
                                <a id="link-update-basket-${ item.key.product.keyname }" class="font-apple link-update-basket" onclick="reloadQuantity(this)" href="#"><spring:message code="update" /></a>
                                <a class="font-apple link-delete-basket" data-toggle="modal" href="#confirm-modal-${ item.key.product.keyname }"><spring:message code="delete" /></a>

                                <div class="modal fade" id="confirm-modal-${ item.key.product.keyname }" tabindex="-1" role="dialog" aria-labelledby="confirm-modal-label-${ item.key.product.keyname }" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="confirm-modal-label-${ item.key.product.keyname }"><spring:message code="confirmation" /></h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body text-left">
                                                <spring:message code="confirmDialog" />
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal"><spring:message code="no" /></button>
                                                <a type="button" class="btn btn-danger" href="<c:url value="/basket/delete?keyname=${ item.key.product.keyname }" />"><spring:message code="yes" /></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

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
        </c:if>
    </div>
</body>
</html>
