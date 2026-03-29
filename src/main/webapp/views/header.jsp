<%@ page contentType="text/html; charset=UTF-8"%>

<!-- Materialize CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<nav>
    <div class="nav-wrapper blue">
        <a href="<%= request.getContextPath() %>/" class="brand-logo" style="margin-left:15px;">
            Library
        </a>

        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="<%= request.getContextPath() %>/author">Авторы</a></li>
            <li><a href="<%= request.getContextPath() %>/publisher">Издательства</a></li>
            <li><a href="<%= request.getContextPath() %>/book">Книги</a></li>
        </ul>
    </div>
</nav>

<div class="container">