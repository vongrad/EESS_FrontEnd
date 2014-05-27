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
                    <tr><th>Title</th><th>Description</th><th>Status</th></tr>
                            <c:forEach var="elective" items="${electives}">
                        <tr>
                            <td>${elective.title}</td>
                            <td>${elective.description}</td>
                            <td class="status">${elective.proposed}</td>
                            <td><button class="approve" name="${elective.electiveId}">Approve</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <form id="approveElective" action="EESS_FrontEnd" method="post">
            <input id="electiveId" type="hidden" name="electiveId">
            <input type="hidden" name="command" value="approveElective">
        </form>
    </body>

    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script>
        $(document).ready(function() {
            $('#table').find('tr').find(".status").each(function() {
                if ($(this).text() == 1) {
                    $(this).text("Approved");
                    $(this).parent().find(".approve").remove();
                } else {
                    $(this).text("Pending");
                }
            });

            $(".approve").click(function() {
                var electiveId = $(this).attr("name");
                $("#electiveId").attr("value", electiveId);
                $("#approveElective").submit();
            });
        });

    </script>

</html>