<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
</head>
<body>
    <div class="main-container">
        <div class="register-form">
            <h2 class="h2-subtitle text-center">Registration</h2>
            <form:form  id="userRegisterForm" method="POST" modelAttribute="userForm">

                <div class="form-group">
                    <form:label path="username">Login</form:label>
                    <form:input path="username" type="text" class="form-control" aria-describedby="usernameError" placeholder="Login"></form:input>
                    <small id="usernameError" class="form-text text-muted"><form:errors path="username" /></small>
                </div>

                <div class="form-group">
                    <form:label path="password">Password</form:label>
                    <form:input path="password" type="password" class="form-control" aria-describedby="passwordError" placeholder="Password"></form:input>
                    <small id="passwordError" class="form-text text-muted"><form:errors path="password" /></small>
                </div>

                <div class="row">
                    <div class="col">

                        <div class="form-group">
                            <form:label path="firstname">First name</form:label>
                            <form:input path="firstname" type="text" class="form-control" aria-describedby="firstnameError" placeholder="First name"></form:input>
                            <small id="firstnameError" class="form-text text-muted"><form:errors path="firstname" /></small>
                        </div>

                    </div>

                    <div class="col">

                        <div class="form-group">
                            <form:label path="name">Name</form:label>
                            <form:input path="name" type="text" class="form-control" aria-describedby="nameError" placeholder="Name"></form:input>
                            <small id="nameError" class="form-text text-muted"><form:errors path="name" /></small>
                        </div>

                    </div>
                </div>

                <div class="form-group">
                    <form:label path="email">Email</form:label>
                    <form:input path="email" type="email" class="form-control" aria-describedby="emailError" placeholder="Email"></form:input>
                    <small id="emailError" class="form-text text-muted"><form:errors path="email" /></small>
                </div>

                <div class="form-group">
                    <form:label path="phoneNumber">Phone number</form:label>
                    <form:input path="phoneNumber" type="text" class="form-control" aria-describedby="phoneNumberError" placeholder="Phone number"></form:input>
                    <small id="phoneNumberError" class="form-text text-muted"><form:errors path="phoneNumber" /></small>
                </div>

                <div class="form-group">
                    <form:label path="birthdate">Birthdate</form:label>
                    <form:input path="birthdate" type="date" class="form-control" aria-describedby="birthdateError" placeholder="Birthdate"></form:input>
                    <small id="birthdateError" class="form-text text-muted"><form:errors path="birthdate" /></small>
                </div>

                <div class="row">
                    <div class="col">

                        <div class="form-group">
                            <form:label path="postalCode">Postal Code</form:label>
                            <form:input path="postalCode" type="number" class="form-control" aria-describedby="postalCodeError" placeholder="Postal Code"></form:input>
                            <small id="postalCodeError" class="form-text text-muted"><form:errors path="postalCode" /></small>
                        </div>

                    </div>

                    <div class="col">

                        <div class="form-group">
                            <form:label path="city">City</form:label>
                            <form:input path="city" type="text" class="form-control" aria-describedby="cityError" placeholder="City"></form:input>
                            <small id="cityError" class="form-text text-muted"><form:errors path="city" /></small>
                        </div>

                    </div>
                </div>

                <div class="form-group">
                    <form:label path="deliveryAddress">Delivery address</form:label>
                    <form:input path="deliveryAddress" type="text" class="form-control" aria-describedby="deliveryAddressError" placeholder="Delivery address"></form:input>
                    <small id="deliveryAddressError" class="form-text text-muted"><form:errors path="deliveryAddress" /></small>
                </div>

                <div class="text-center">
                    <p>
                        <form:button class="button-form-login font-apple">Register</form:button>
                    </p>
                    <p>
                        <a href="<c:url value="/login" />">Already have an account ?</a>
                    </p>
                </div>

            </form:form>
        </div>
    </div>
</body>
</html>
