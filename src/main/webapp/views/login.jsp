<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Логин</title>

<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">

</head>
<body class="container">

<h4>Вход в систему</h4>

<%
String error = request.getParameter("error");
if ("1".equals(error)) {
%>
<p style="color:red;">Неверный логин или пароль</p>
<%
}
%>

<form method="POST" action="<%= request.getContextPath() %>/login">

<div class="input-field">
    <input type="text" name="login" required>
    <label class="active">Логин</label>
</div>

<div class="input-field">
    <input type="password" name="password" required>
    <label class="active">Пароль</label>
</div>

    <button class="btn blue">Войти</button>
</form>

</body>
</html>