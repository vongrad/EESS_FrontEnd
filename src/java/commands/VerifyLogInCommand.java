package commands;

import commands.Command;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import data.SecurityRole;


public class VerifyLogInCommand implements Command {
   private final Map<SecurityRole, String> roleToTarget;
    private final String loginFailed;

    public VerifyLogInCommand(Map<SecurityRole, String> targetRoles, String logInFaildedPage) {
        this.roleToTarget = targetRoles;
        this.loginFailed = logInFaildedPage;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String nextPage = loginFailed;
        try {System.out.println("GOes here");
            request.login(userName, password);
            
            for (SecurityRole role : roleToTarget.keySet()) {
                if (role.equals(data.SecurityRole.HeadOfProgramme)) {
                    System.out.println("da");
                    if(request.isUserInRole(data.SecurityRole.HeadOfProgramme.toString()))
                        System.out.println("da");
                    else
                        System.out.println("nu");
                }
                if (request.isUserInRole(role.toString())) {
                  
                    nextPage = roleToTarget.get(role);
                    break;
                }
            }
        } catch (ServletException ex) {
         //request.getSession().setAttribute("error", "wrong username or password");
            ex.printStackTrace();
            Logger.getLogger(VerifyLogInCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return nextPage;
    

}
}
