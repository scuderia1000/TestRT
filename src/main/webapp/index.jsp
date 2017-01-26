<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search User</title>

    <script src="http://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script src="js/ajax-script.js" type="text/javascript"></script>
</head>
<body>
    <form>
        Enter Your Name: <input type="text" id="userName" />
    </form>
    <br>
    <br>

    <strong>Ajax Response</strong>:
    <div id="ajaxGetUserServletResponse"></div>
</body>
</html>
