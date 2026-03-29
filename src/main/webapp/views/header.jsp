<%@ page contentType="text/html; charset=UTF-8"%>

<%
String pageTitle = request.getParameter("title");
if (pageTitle == null) pageTitle = "Библиотека";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title><%= pageTitle %></title>

<!-- Material Icons (официально от Google) -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!-- Favicon (Material icon book) -->
<link rel="icon" type="image/svg+xml"
      href="https://fonts.gstatic.com/s/i/materialicons/book/v11/24px.svg">

<!-- Materialize CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>

<body>

<nav>
    <div class="nav-wrapper blue">
        <a href="<%= request.getContextPath() %>/" class="brand-logo" style="margin-left:15px;">
            <i class="material-icons">menu_book</i> Библиотека
        </a>

        <ul class="right">
            <li><a href="<%= request.getContextPath() %>/author">Авторы</a></li>
            <li><a href="<%= request.getContextPath() %>/publisher">Издательства</a></li>
            <li><a href="<%= request.getContextPath() %>/book">Книги</a></li>
            <li class="red">
    <a href="<%= request.getContextPath() %>/logout" class="white-text">
        Выход
    </a>
</li>
        </ul>
    </div>
</nav>

<div class="container">