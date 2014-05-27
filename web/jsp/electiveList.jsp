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
        <c:import url="../snippets/menu.html"></c:import>
        <div id="content">
            <div>
                <p>Electives</p>
                <table id="table">
                    <tr><th>Title</th><th>Description</th></tr>
                    <c:forEach var="elective" items="${electives}">
                        <tr>
                            <td>${elective.title}</td>
                            <td>${elective.description}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="js/main.js"></script>

</html>