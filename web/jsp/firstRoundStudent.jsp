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
                <li class="menu-li"><a href="EESS_FrontEnd?command=main"><div>Set Pools</div></a></li>
                <!--//TODO: finish up all this-->
                <li class="menu-li"><a href="EESS_FrontEnd?command=firstRoundStudent"><div>First Round Student Vote</div></a></li>
                <li class="menu-li"><a href="EESS_FrontEnd?command=getFirstRound"><div>1st Round</div></a></li>
                <!--<li class="menu-li"><a href="#"><div>2nd Round</div></a></li>-->
                <li class="menu-li"><a href="EESS_FrontEnd?command=getSuggestedElectives"><div>Electives</div></a></li>
                <li class="menu-li"><a href="EESS_FrontEnd?command=approveElective"><div>Approve elective</div></a></li>
                <li class="menu-li"><a href="EESS_FrontEnd?command=suggestElective"><div>Suggest Elective</div></a></li>
            </ul>
        </div>
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
                    <p>First priorities</p>
                    <ul id="sortable2" class="connectedSortable">
                    </ul>
                </div>
                <div>
                    <p>Second priorities</p>
                    <ul id="sortable3" class="connectedSortable">
                    </ul>
                </div>
                <form>
                    <input id="A1" type="hidden" name="A1">
                    <input id="A2" type="hidden" name="A2">
                    <input id="B1" type="hidden" name="B1">
                    <input id="B2" type="hidden" name="B2">
                    <input id="studentId" type="hidden" name="studentId">
                    <input type="hidden" name="command" value="firstRoundStudent">
                    <select id="student">
                        <c:forEach var="student" items="${students}">
                            <option value="${student.cpr}">${student.firstName} ${student.lastName}</option>
                        </c:forEach>
                    </select>
                    <input id=commit type="submit" value="Chose electives">
                </form>
                <!--<button id="commit">Chose electives</button>-->
            </div>
        </div>
    </body>

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script>
        $("#commit").prop("disabled", true);
        $("#student").change(function(){
            $("#studentId").attr("value", $("#student option:selected").attr("value"));
        });
        $("#sortable1, #sortable2, #sortable3").sortable({
            connectWith: ".connectedSortable",
            stop: function() {
                if ($("#sortable2").children("li").length === 2 && $("#sortable3").children("li").length === 2) {
                    $("#commit").prop("disabled", false);
                    $("#A1").attr("value", $("#sortable2").children().first().text());
                    $("#A2").attr("value", $("#sortable2").children().last().text());
                    $("#B1").attr("value", $("#sortable3").children().first().text());
                    $("#B2").attr("value", $("#sortable3").children().last().text());
                } else {
                    $("#commit").prop("disabled", true);
                }
            }
        }).disableSelection();
    </script>

</html>