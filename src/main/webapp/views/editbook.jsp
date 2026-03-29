<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="domain.Book"%>
<%@ page import="domain.Author"%>
<%@ page import="domain.Publisher"%>
<%@ page import="java.util.List"%>

<%
Book b = (Book) request.getAttribute("bookEdit");
List<Author> authors = (List<Author>) request.getAttribute("authors");
List<Publisher> publishers = (List<Publisher>) request.getAttribute("publishers");
%>

<jsp:include page="header.jsp"/>

<h4>Редактирование книги</h4>

<form method="POST" action="<%= request.getContextPath() %>/editbook">

    <input type="hidden" name="id" value="<%= b.getId() %>"/>

    <div class="input-field">
        <input type="text" name="title" value="<%= b.getTitle() %>" required>
        <label class="active">Название</label>
    </div>

    <div class="input-field">
        <input type="text" name="code" value="<%= b.getCode() %>" required>
        <label class="active">ISBN</label>
    </div>

    <div class="input-field">
        <input type="number" name="year" value="<%= b.getYearPublish() %>">
        <label class="active">Год</label>
    </div>

    <div class="input-field">
        <input type="number" name="pages" value="<%= b.getCountPage() %>">
        <label class="active">Страниц</label>
    </div>

    <p>
        <label>
            <input type="checkbox" name="hardcover" <%= b.getHardcover() ? "checked" : "" %> />
            <span>Переплет</span>
        </label>
    </p>

    <p>
        <label>
            <input type="checkbox" name="status" <%= b.getStatus() ? "checked" : "" %> />
            <span>В наличии</span>
        </label>
    </p>

    <div class="input-field">
        <textarea name="abstract" class="materialize-textarea"><%= b.getAbstractText() %></textarea>
        <label class="active">Описание</label>
    </div>

    <p>Автор:</p>
    <select name="authorId" class="browser-default">
        <%
        for (Author a : authors) {
        %>
        <option value="<%= a.getId() %>" <%= a.getId().equals(b.getAuthorId()) ? "selected" : "" %>>
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
        <option value="<%= p.getId() %>" <%= p.getId().equals(b.getPublishId()) ? "selected" : "" %>>
            <%= p.getNamePublisher() %>
        </option>
        <%
        }
        %>
    </select>

    <br><br>
    <button class="btn blue">Сохранить</button>
</form>

<jsp:include page="footer.jsp"/>