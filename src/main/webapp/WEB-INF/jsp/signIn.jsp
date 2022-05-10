<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/jsp/style.css" %>
</style>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/signIn" method="post" class="form">
    <label>Sign in</label>
    <div id="wrapper">
        <div id="arrow"></div>
        <input name="login" id="login" placeholder="Login" type="text">
        <input name="password" id="password" placeholder="Password" type="password">
    </div>
    <button type="submit">
    <span>
      Sign in
    </span>
        <a href="https://oauth.vk.com/authorize?client_id=7994580&redirect_uri=http://localhost:8080/vk&display=page&v=5.131&scope=status,email">Войти через VK</a>
    </button>
</form>
<h3>${signInStatus}</h3>
</body>
</html>
