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
                <div id="mainTables">
                    <div>
                        <p>All subjects</p>
                        <ul id="sortable1" class="connectedSortable">
                        <c:forEach var="elective" items="${electives}">
                            <li class="ui-state-highlight">${elective.title}</li>
                            </c:forEach>
                    </ul>
                </div>
                <div>
                    <p>POOL A</p>
                    <ul id="sortable2" class="connectedSortable">
                    </ul>
                </div>
                <div>
                    <p>POOL B</p>
                    <ul id="sortable3" class="connectedSortable">
                    </ul>
                </div>
            </div>
            <div>
                <div><p id="unhappy-students">Unhappy students: </p></div>
                <h3>Students</h3>
                <table id="table">

                </table>
            </div>
        </div>
    </body>

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="js/main.js"></script>

</html>