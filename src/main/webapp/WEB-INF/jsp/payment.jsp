<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

            <input type="hidden" name="business" value="sb-cpsky2499271@business.example.com">

            <input type="hidden" name="password" value="EA0V6wwDqrpGnDVzUFaJdhULCvVN4LOiH27vaeLOuL8mnak0RS3anuNPdt68JVRhEaM_yRPabq8HDmSS">

            <input type="hidden" name="cert_id" value="AeqPLwU0oJhEKy1I2iu8QSjDjVeXB5wQAtlAdrDXPBzMDm53-C3NAtyD0BPDLKwVef5mdRnkt5RHILaU">

            <input type="hidden" name="cmd" value="_xclick">

            <input type="hidden" name="amount" value="${ totalPrice }">

            <input type="hidden" name="currency_code" value="EUR">

            <input type="hidden" name="item_name" value="Green garden product(s)">

            <input type="hidden" name="return" value="http://localhost:8082/home">

            <input type="image" name="submit"
                   src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
                   alt="PayPal - The safer, easier way to pay online">
            <img alt="" width="1" height="1"
                 src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >

        </form>
    </div>
</body>
</html>
