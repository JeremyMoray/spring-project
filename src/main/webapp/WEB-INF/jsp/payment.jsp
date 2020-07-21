<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <h2 class="h2-subtitle"><spring:message code="payment" /></h2>

        <p>
            <spring:message code="payPaypal" /> :
        </p>
        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

            <input type="hidden" name="business" value="sb-3zk7h2683970@business.example.com">

            <input type="hidden" name="password" value="EKbztLMMfLsyS9SSD7KMyH1_b_96KiT0ZEt6nZeyowIBzPgQbTN4UYi4PrOMU7Sjg6_kDnDcv4GOx6Pq">

            <input type="hidden" name="cert_id" value="AVrgEMU1IYzIaY7eMSO0LxxYJ0z9pE2ep2h9V6RvzGRNOrWL0hGkYxlhbhw934UA4IzYhJRftxZ3uiJu">

            <input type="hidden" name="cmd" value="_xclick">

            <input type="hidden" name="amount" value="${ totalPrice }">

            <input type="hidden" name="currency_code" value="EUR">

            <input type="hidden" name="item_name" value="Green garden product(s)">

            <input type="hidden" name="return" value="http://localhost:8082/basket/deleteAll">

            <input type="image" name="submit"
                   src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
                   alt="PayPal - The safer, easier way to pay online">
            <img alt="" width="1" height="1"
                 src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >

        </form>
    </div>
</body>
</html>
