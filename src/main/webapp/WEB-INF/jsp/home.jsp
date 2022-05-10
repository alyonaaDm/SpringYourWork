<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-INF/HTML/css/style.css">
</head>
<body>

    <form action="${pageContext.request.contextPath}/home" method="post" class="form">
        <p>Sign Up</p>
        <p>
            <label for="login">Login<input id="login" type="text" name="login" value="hhfhfh"></label>
            <label for="password">Password<input id="password" type="password" name="password"></label>
            <label for="repassword">Repassword<input id="repassword" type="password" name="repassword" value=""></label>
            <label for="email">Email<input id="email" type="email" name="email" value=""></label>
        <p><input type="submit"></p>
    </form>
<p>
    ${validation}

</p>

<%
    out.println(LocalDateTime.now());
%>

    <form action="${pageContext.request.contextPath}/home" method="get" class="form">
        <p>Sign Up</p>
        <p>
            <label for="search">Login<input id="search" type="text" name="query" placeholder="Введите ваш запрос"></label>
        </p>
        <p><input type="submit" value="GET!"></p>
    </form>

</body>
</html>
