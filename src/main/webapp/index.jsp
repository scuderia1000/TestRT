<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search User</title>

    <script src="http://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>

    <link href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css" type="text/css"
          rel="stylesheet"/>

    <script src="js/ajax-script.js" type="text/javascript"></script>

</head>
<body>
<div class="container">
    <h3>Введите данные для поиска пользователя</h3>
    <div id="alert"></div>
    <form class="form-inline">
        <div class="form-group" id="usersSearch">
            <input type="text" id="lastName" class="form-control" placeholder="Фамилия"/>
            <input type="text" id="firstName" class="form-control" placeholder="Имя"/>
            <input type="text" id="middleName" class="form-control" placeholder="Отчество"/>
            <input type="text" id="city" class="form-control" placeholder="Город проживания"/>
            <input type="text" id="car" class="form-control" placeholder="Марка машины"/>
            <input class="btn btn-default" id="search" type="button" value="Найти"/>
        </div>
    </form>
</div>
<br>
<br>

<div class="container">
    <h3>Результат поиска</h3>
    <form class="form-horizontal">
        <div class="form-group">
            <table id="users" class="table table-striped">
                <tr>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Отчество</th>
                    <th>Город проживания</th>
                    <th>Марка машины</th>
                </tr>
            </table>
        </div>
    </form>
</div>
</body>
</html>
