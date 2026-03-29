<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.Book"%>
<%@ page import="domain.Author"%>
<%@ page import="domain.Publisher"%>

<%
List<Book> books = (List<Book>) request.getAttribute("books");
List<Author> authors = (List<Author>) request.getAttribute("authors");
List<Publisher> publishers = (List<Publisher>) request.getAttribute("publishers");
%>

<jsp:include page="header.jsp"/>

<h4>Книги</h4>

<table class="striped">
<tr>
    <th>ID</th>
    <th>Название</th>
    <th>ISBN</th>
    <th>Год</th>
    <th>Страниц</th>
    <th>Автор</th>
    <th>Издательство</th>
    <th>Действия</th>
</tr>

<%
for (Book b : books) {
%>
<tr>
    <td><%= b.getId() %></td>
    <td><%= b.getTitle() %></td>
    <td><%= b.getCode() %></td>
    <td><%= b.getYearPublish() %></td>
    <td><%= b.getCountPage() %></td>

    <!-- Автор -->
    <td>
    <%
    String authorName = "";
    for (Author a : authors) {
        if (a.getId().equals(b.getAuthorId())) {
            authorName = a.getLastName() + " " + a.getFirstName();
            break;
        }
    }
    %>
    <%= authorName %>
    </td>

    <!-- Издательство -->
    <td>
    <%
    String publisherName = "";
    for (Publisher p : publishers) {
        if (p.getId().equals(b.getPublishId())) {
            publisherName = p.getNamePublisher();
            break;
        }
    }
    %>
    <%= publisherName %>
    </td>

    <td>
        <a class="btn-small blue" href="editbook?id=<%= b.getId() %>">Редактировать</a>
        <a class="btn-small red" href="deletebook?id=<%= b.getId() %>">Удалить</a>
    </td>
</tr>
<%
}
%>
</table>

<h5>Добавить книгу</h5>

<form method="POST" action="<%= request.getContextPath() %>/book">

    <div class="input-field">
        <input type="text" name="title" required>
        <label>Название</label>
    </div>

    <div class="input-field">
        <input type="text" name="code" required>
        <label>ISBN</label>
    </div>

    <div class="input-field">
        <input type="number" name="year">
        <label>Год</label>
    </div>

    <div class="input-field">
        <input type="number" name="pages">
        <label>Страниц</label>
    </div>

    <p>
        <label>
            <input type="checkbox" name="hardcover"/>
            <span>Переплет</span>
        </label>
    </p>

    <p>
        <label>
            <input type="checkbox" name="status"/>
            <span>В наличии</span>
        </label>
    </p>

    <div class="input-field">
        <textarea name="abstract" class="materialize-textarea"></textarea>
        <label>Описание</label>
    </div>

    <p>Автор:</p>
    <select name="authorId" class="browser-default">
        <%
        for (Author a : authors) {
        %>
        <option value="<%= a.getId() %>">
            <%= a.getLastName() %> <%= a.getFirstName() %>
        </option>
        <%
        }
        %>
    </select>

    <p>Издательство:</p>
    <select name="publisherId" class="browser-default">
        <%
        for (Publisher p : publishers) {
        %>
        <option value="<%= p.getId() %>">
            <%= p.getNamePublisher() %>
        </option>
        <%
        }
        %>
    </select>

    <br><br>
    <button class="btn green">Добавить</button>
</form>

<jsp:include page="footer.jsp"/>