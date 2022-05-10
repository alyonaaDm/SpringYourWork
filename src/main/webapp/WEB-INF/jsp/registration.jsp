<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/jsp/style.css" %>
</style>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/signUp" method="post" class="form">
    <label>Sign up</label>
    <div id="wrapper">
        <div id="arrow"></div>
        <label for="login"></label><input name="login" id="login" placeholder="Login" type="text">
        <label for="password"></label><input name="password" id="password" placeholder="Password" type="password">
        <label for="repassword"></label><input name="repassword" id="repassword" placeholder="Repeat password"
                                               type="password">
        <label for="firstName"></label><input name="firstName" id="firstName" placeholder="First name" type="text">
        <label for="lastName"></label><input name="lastName" id="lastName" placeholder="Last name" type="text">
    </div>
    <button type="submit">
    <span>
      Sign up
    </span>
    </button>
</form>
<h3>${registrationStatus}</h3>
</body>
</html>
