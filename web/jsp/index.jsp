<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Electronic elective subject system</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div id="header"><p>Electronic elective subject system</p></div>

        <input id="student" type="hidden" value="${sessionScope.student.cpr}">
        <form id="login" action="EESS_FrontEnd" method="post">
            <input type="hidden" name="command" value="main">
        </form>

        <div id="content">
            <form>
                <table id="table">
                    <tr><td>CPR: </td><td><input type="text" name="cpr" value="014323-4519"></td></tr>
                    <tr><td>Password: </td><td><input type="text" name="password"></td></tr>
                </table>
                <input type="hidden" name="command" value="index">
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script>
        if ($("#student").attr("value") !== "") {
            $("#login").submit();
        }
    </script>

</html>