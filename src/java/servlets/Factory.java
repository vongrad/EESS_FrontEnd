package servlets;

import commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import data.SecurityRole;

public class Factory {

    private static Factory instance = new Factory();
    private Map<String, Command> commands = new HashMap<>();
    Map<SecurityRole, String> rolePages = new HashMap();

    private Factory() {
        ////mains
       
        commands.put("logIn", new LogInCommand("/jsp/Home.jsp", SecurityRole.All));
        commands.put("logInS", new LogInCommandS("/jsp/HomeS.jsp", SecurityRole.All));
        commands.put("verifylogin", new VerifyLogInCommand(rolePages, "/jsp/HomeS.jsp"));
        
        rolePages.put(SecurityRole.HeadOfProgramme, "/headOfProgramme/main.jsp");
        rolePages.put(SecurityRole.All, "/jsp/HomeS.jsp");
        commands.put("main", new TargetCommand("/headOfProgramme/main.jsp", SecurityRole.HeadOfProgramme));

        commands.put("logout", new LogoutCommand("/jsp/Home.jsp", SecurityRole.All));
        // commands.put("verifylogin", new VerifyLogInCommand(rolePages, "/logInPage.jsp"));
    }

    public static Factory getInstance() {
        return instance;
    }

    public Command getCommand(String cmdStr, HttpServletRequest res) {
        if (cmdStr == null) {
            cmdStr = "logIn";
        }
        System.out.println(cmdStr);
//        return commands.get(cmdStr);
//        if (cmdStr == null) {
//            cmdStr = "logIn";
//        }
        Command cmd = commands.get(cmdStr);

        //This is the most important place in terms of security
        //If you fail here your security is broken
        if (cmd instanceof TargetCommand) {
            SecurityRole requiredRole = ((TargetCommand) cmd).getRole();
            if (requiredRole != SecurityRole.All && !res.isUserInRole(requiredRole.toString())) {
                throw new SecurityException("You don't have rights for this");
            }
        }

        return cmd;
    }

}
