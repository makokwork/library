<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.Author"%>

<%
List<Author> authors = (List<Author>) request.getAttribute("authors");
%>

<jsp:include page="header.jsp"/>

<h4>Авторы</h4>

<table class="striped">
<tr>
    <th>ID</th>
    <th>Фамилия</th>
    <th>Имя</th>
    <th>Действия</th>
</tr>

<%
for (Author a : authors) {
%>
<tr>
    <td><%= a.getId() %></td>
    <td><%= a.getLastName() %></td>
    <td><%= a.getFirstName() %></td>
    <td>
        <a class="btn-small blue" href="editauthor?id=<%= a.getId() %>">Редактировать</a>
        <a class="btn-small red" href="deleteauthor?id=<%= a.getId() %>">Удалить</a>
    </td>
</tr>
<%
}
%>

</table>

<hr>

<h5>Добавить автора</h5>

<form method="POST" action="<%= request.getContextPath() %>/author">

    <div class="input-field">
        <input type="text" name="lastname" required>
        <label>Фамилия</label>
    </div>

    <div class="input-field">
        <input type="text" name="firstname" required>
        <label>Имя</label>
    </div>

    <button class="btn green">Добавить</button>
</form>

<jsp:include page="footer.jsp"/>