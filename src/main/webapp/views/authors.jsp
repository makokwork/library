<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.Author"%>

<%
List<Author> authors = (List<Author>) request.getAttribute("authors");
%>

<jsp:include page="header.jsp"/>

<h4>Список авторов</h4>

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

<jsp:include page="footer.jsp"/>