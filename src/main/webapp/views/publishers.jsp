<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.Publisher"%>

<%
List<Publisher> publishers = (List<Publisher>) request.getAttribute("publishers");
%>

<jsp:include page="header.jsp"/>

<h4>Издательства</h4>

<table class="striped">
<tr>
    <th>ID</th>
    <th>Название</th>
    <th>Адрес</th>
    <th>Сайт</th>
    <th>Действия</th>
</tr>

<%
for (Publisher p : publishers) {
%>
<tr>
    <td><%= p.getId() %></td>
    <td><%= p.getNamePublisher() %></td>
    <td><%= p.getAddress() %></td>
    <td><%= p.getSite() %></td>
    <td>
        <a class="btn-small blue" href="editpublisher?id=<%= p.getId() %>">Редактировать</a>
        <a class="btn-small red" href="deletepublisher?id=<%= p.getId() %>">Удалить</a>
    </td>
</tr>
<%
}
%>
</table>

<h5>Добавить издательство</h5>

<form method="POST" action="<%= request.getContextPath() %>/publisher">

    <div class="input-field">
        <input type="text" name="name" required>
        <label>Название</label>
    </div>

    <div class="input-field">
        <input type="text" name="address">
        <label>Адрес</label>
    </div>

    <div class="input-field">
        <input type="text" name="site">
        <label>Сайт</label>
    </div>

    <button class="btn green">Добавить</button>
</form>

<jsp:include page="footer.jsp"/>