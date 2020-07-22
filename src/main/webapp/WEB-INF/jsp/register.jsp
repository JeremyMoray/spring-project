<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <script>
        function init(){
            let passwordInput = document.getElementById("password-input");
            let confirmPasswordInput = document.getElementById("confirm-password-input");

            passwordInput.onchange = validatePassword;
            confirmPasswordInput.onkeyup = validatePassword;

            function validatePassword() {
                <spring:message code="passwordNotMatch" var="passwordPlaceholder"/>
                if(passwordInput.value !== confirmPasswordInput.value) {
                    confirmPasswordInput.setCustomValidity("${ passwordPlaceholder }");
                }
                else{
                    confirmPasswordInput.setCustomValidity('');
                }
            }

            let phoneNumber = document.getElementById('phone-number-input');

            phoneNumber.onkeydown = function(e) {
                if(!((e.key >= 1 && e.key <= 9) || e.key === 'Backspace')) {
                    return false;
                }
            }
        }
        window.onload = init;
    </script>
</head>
<body>
    <sec:authorize access="!isAuthenticated()">
        <div class="main-container">
            <div class="register-form">
                <h2 class="h2-subtitle text-center"><spring:message code="registration" /></h2>
                <form:form  id="userRegisterForm" method="POST" modelAttribute="userForm">

                    <div class="form-group">
                        <spring:message code="username" var="loginPlaceholder"/>
                        <form:label path="username">${loginPlaceholder}</form:label> *
                        <form:input path="username" type="text" class="form-control" aria-describedby="usernameError" placeholder="${loginPlaceholder}"></form:input>
                        <small id="usernameError" class="form-text text-muted"><form:errors path="username" class="text-error"/></small>
                        <c:if test="${ existingUserError }">
                            <small class="text-error"><spring:message code="existingUser" /></small>
                        </c:if>
                    </div>

                    <div class="form-group">
                        <spring:message code="password" var="passwordPlaceholder"/>
                        <form:label path="password">${passwordPlaceholder}</form:label> *
                        <form:input id="password-input" path="password" type="password" class="form-control" aria-describedby="passwordError" placeholder="${passwordPlaceholder}"></form:input>
                        <small id="passwordError" class="form-text text-muted"><form:errors path="password" class="text-error"/></small>
                    </div>

                    <div class="form-group">
                        <spring:message code="confirmPassword" var="confirmPasswordPlaceholder"/>
                        <label>${confirmPasswordPlaceholder}</label> *
                        <input id="confirm-password-input" type="password" class="form-control" placeholder="${passwordPlaceholder}" />
                    </div>

                    <div class="row">
                        <div class="col">

                            <div class="form-group">
                                <spring:message code="firstName" var="firstNamePlaceholder"/>
                                <form:label path="firstname">${firstNamePlaceholder}</form:label>
                                <form:input path="firstname" type="text" class="form-control" aria-describedby="firstnameError" placeholder="${firstNamePlaceholder}"></form:input>
                                <small id="firstnameError" class="form-text text-muted"><form:errors path="firstname" class="text-error"/></small>
                            </div>

                        </div>

                        <div class="col">

                            <div class="form-group">
                                <spring:message code="name" var="namePlaceholder"/>
                                <form:label path="name">${namePlaceholder}</form:label>
                                <form:input path="name" type="text" class="form-control" aria-describedby="nameError" placeholder="${namePlaceholder}"></form:input>
                                <small id="nameError" class="form-text text-muted"><form:errors path="name" class="text-error"/></small>
                            </div>

                        </div>
                    </div>

                    <div class="form-group">
                        <spring:message code="email" var="emailPlaceholder"/>
                        <form:label path="email">${emailPlaceholder}</form:label> *
                        <form:input path="email" type="email" class="form-control" aria-describedby="emailError" placeholder="${emailPlaceholder}"></form:input>
                        <small id="emailError" class="form-text text-muted"><form:errors path="email" class="text-error"/></small>
                        <c:if test="${ existingEmailError }">
                            <small class="text-error"><spring:message code="existingEmail" /></small>
                        </c:if>
                    </div>

                    <div class="form-group">
                        <spring:message code="phoneNumber" var="phoneNumberPlaceholder"/>
                        <form:label path="phoneNumber">${phoneNumberPlaceholder}</form:label>
                        <form:input id="phone-number-input" path="phoneNumber" type="text" class="form-control" aria-describedby="phoneNumberError" placeholder="${phoneNumberPlaceholder}"></form:input>
                        <small id="phoneNumberError" class="form-text text-muted"><form:errors path="phoneNumber" class="text-error"/></small>
                    </div>

                    <div class="form-group">
                        <spring:message code="birthdate" var="birthdatePlaceholder"/>
                        <form:label path="birthdate">${birthdatePlaceholder}</form:label>
                        <form:input path="birthdate" type="date" class="form-control" aria-describedby="birthdateError"></form:input>
                        <small id="birthdateError" class="form-text text-muted"><form:errors path="birthdate" class="text-error"/></small>
                    </div>

                    <div class="row">
                        <div class="col">

                            <div class="form-group">
                                <spring:message code="postalCode" var="postalCodePlaceholder"/>
                                <form:label path="postalCode">${postalCodePlaceholder}</form:label> *
                                <form:input path="postalCode" type="number" class="form-control" aria-describedby="postalCodeError" placeholder="${postalCodePlaceholder}"></form:input>
                                <small id="postalCodeError" class="form-text text-muted"><form:errors path="postalCode" class="text-error"/></small>
                            </div>

                        </div>

                        <div class="col">

                            <div class="form-group">
                                <spring:message code="city" var="cityPlaceholder"/>
                                <form:label path="city">${cityPlaceholder}</form:label> *
                                <form:input path="city" type="text" class="form-control" aria-describedby="cityError" placeholder="${cityPlaceholder}"></form:input>
                                <small id="cityError" class="form-text text-muted"><form:errors path="city" class="text-error"/></small>
                            </div>

                        </div>
                    </div>

                    <div class="form-group">
                        <spring:message code="deliveryAddress" var="deliveryAddressPlaceholder"/>
                        <form:label path="deliveryAddress">${deliveryAddressPlaceholder}</form:label> *
                        <form:input path="deliveryAddress" type="text" class="form-control" aria-describedby="deliveryAddressError" placeholder="${deliveryAddressPlaceholder}"></form:input>
                        <small id="deliveryAddressError" class="form-text text-muted"><form:errors path="deliveryAddress" class="text-error"/></small>
                    </div>

                    <div class="text-center">
                        <p>
                            <form:button class="button-form-login font-apple"><spring:message code="register" /></form:button>
                        </p>
                        <p>
                            <a href="<c:url value="/login" />"><spring:message code="alreadyAnAccount" /></a>
                        </p>
                    </div>

                </form:form>
            </div>
        </div>
    </sec:authorize>
</body>
</html>
