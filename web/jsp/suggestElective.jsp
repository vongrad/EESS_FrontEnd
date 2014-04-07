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
        <div id="menu">
            <ul id="menu-ul">
                <li id="menu-text"><div>Menu</div></li>
                <li class="menu-li"><a href="EESS_FrontEnd?command=main"><div>Main</div></a></li>
                <!--//TODO: finish up all this-->
                <li class="menu-li"><a href="EESS_FrontEnd?command=getFirstRound"><div>1st Round</div></a></li>
                <li class="menu-li"><a href="#"><div>2nd Round</div></a></li>
                <li class="menu-li"><a href="EESS_FrontEnd?command=getSuggestedElectives"><div>Electives</div></a></li>
                <li class="menu-li"><a href="EESS_FrontEnd?command=suggestElective"><div>Suggest Electives</div></a></li>
            </ul>
        </div>
        <div id="content">
            <div>
                <p>${info}</p>
                <form action="EESS_FrontEnd" method="post">
                    <table id="table">
                        <tr><td>Title:</td><td><input type="text" name="title" value=""></td></tr>
                        <tr><td>Description</td><td><input type="text" name="description" value=""></td></tr>
                        <tr><td>Teacher</td><td>
                                <select name="teacher">
                                    <c:forEach var="teacher" items="${teachers}">
                                        <option value="${teacher.CPR}">${teacher.firstName} ${teacher.lastName}</option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                        <input type="hidden" name="command" value="suggestElective">
                    </table>
                    <input type="submit" value="Add">
                </form>
            </div>
        </div>
    </body>

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="js/main.js"></script>

</html>