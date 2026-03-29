<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:include page="views/header.jsp"/>

<div class="center" style="margin-top: 50px;">

    <h3>Библиотека</h3>
    <p>Выберите раздел</p>

    <div class="row" style="margin-top: 40px;">

        <div class="col s12 m4">
            <div class="card">
                <div class="card-content center">
                    <span class="card-title">Книги</span>
                    <p>Управление книгами</p>
                </div>
                <div class="card-action center">
                    <a class="btn blue" href="<%= request.getContextPath() %>/book">Открыть</a>
                </div>
            </div>
        </div>

        <div class="col s12 m4">
            <div class="card">
                <div class="card-content center">
                    <span class="card-title">Авторы</span>
                    <p>Управление авторами</p>
                </div>
                <div class="card-action center">
                    <a class="btn green" href="<%= request.getContextPath() %>/author">Открыть</a>
                </div>
            </div>
        </div>

        <div class="col s12 m4">
            <div class="card">
                <div class="card-content center">
                    <span class="card-title">Издательства</span>
                    <p>Управление издательствами</p>
                </div>
                <div class="card-action center">
                    <a class="btn orange" href="<%= request.getContextPath() %>/publisher">Открыть</a>
                </div>
            </div>
        </div>

    </div>

</div>

<jsp:include page="views/footer.jsp"/>