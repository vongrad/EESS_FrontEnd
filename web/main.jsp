


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
                <li class="menu-li"><a href="EESS_FrontEnd?command=index"><div>Main</div></a></li>
                <!--//TODO: finish up all this-->
                <li class="menu-li"><a href="#"><div>1st Round</div></a></li>
                <li class="menu-li"><a href="#"><div>2nd Round</div></a></li>
                <li class="menu-li"><a href="#"><div>Students</div></a></li>
                <li class="menu-li"><a href="#"><div>Contacts</div></a></li>
            </ul>
        </div>
        <div id="content">
            <div id="mainTables">
                <div>
                    <p>All subjects</p>
                    <ul id="sortable1" class="connectedSortable">
                        <li class="ui-state-highlight">Artificial Intelligence</li>
                        <li class="ui-state-highlight">CSharp</li>
                        <li class="ui-state-highlight">Python</li>
                        <li class="ui-state-highlight">PHP</li>
                        <li class="ui-state-highlight">Free time, do nothing</li>
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