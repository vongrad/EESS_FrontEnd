<%-- 
    Document   : HOMES
    Created on : Mar 30, 2014, 10:35:52 PM
    Author     : Stefan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
          <ul id="login">
                <form action="EESS_FrontEnd" method="post">
                <li id="textLogin">Login</li>
                    <li class="val">Username:<input id="username" type="text" name="username"/></li>
                    <li class="val">Password:<input id="password"  type="password" name="password"/></li>
                    <li class="val"><input type='hidden' name='command' value='verifylogin'/></li>
                    <li class="val"><input id="loginBtn" type="submit" value="Log In"/></li>
                </form>
            </ul>
    </body>
</html>
