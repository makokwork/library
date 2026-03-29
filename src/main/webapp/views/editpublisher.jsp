<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="domain.Publisher"%>

<%
Publisher p = (Publisher) request.getAttribute("publisherEdit");
%>

<jsp:include page="header.jsp"/>

<h4>Редактирование издательства</h4>

<form method="POST" action="<%= request.getContextPath() %>/editpublisher">

    <input type="hidden" name="id" value="<%= p.getId() %>"/>

    <div class="input-field">
        <input type="text" name="name" value="<%= p.getNamePublisher() %>" required>
        <label class="active">Название</label>
    </div>

    <div class="input-field">
        <input type="text" name="address" value="<%= p.getAddress() %>">
        <label class="active">Адрес</label>
    </div>

    <div class="input-field">
        <input type="text" name="site" value="<%= p.getSite() %>">
        <label class="active">Сайт</label>
    </div>

    <button class="btn blue">Сохранить</button>
</form>

<jsp:include page="footer.jsp"/>