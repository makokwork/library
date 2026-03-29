<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="domain.Author"%>

<%
Author a = (Author) request.getAttribute("authorEdit");
%>

<html>
<head>
<title>Редактировать автора</title>
</head>
<body>

<h2>Редактирование автора</h2>

<form method="POST" action="<%= request.getContextPath() %>/editauthor">

    <input type="hidden" name="id" value="<%= a.getId() %>"/>

    <input type="text" name="lastname" value="<%= a.getLastName() %>" required/>
    <input type="text" name="firstname" value="<%= a.getFirstName() %>" required/>

    <button type="submit">Сохранить</button>
</form>

</body>
</html>