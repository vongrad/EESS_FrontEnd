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
                <p>Students</p>
                <table id="table">
                    <tr><th>Name</th><th>First Priorities</th><th>Second Priorities</th></tr>
                    <c:forEach var="vote" items="${votes}">
                        <tr>
                            <td>${vote.student.firstName} ${vote.student.lastName}</td>
                            <td>${vote.firstPriority1.title}, ${vote.firstPriority2.title}</td>
                            <td>${vote.secondPriority1.title}, ${vote.secondPriority2.title}</td>
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