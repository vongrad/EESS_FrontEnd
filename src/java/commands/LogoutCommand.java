package commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import data.SecurityRole;

public class LogoutCommand extends TargetCommand{

    public LogoutCommand(String target, SecurityRole role) {
    super(target, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.getSession().removeAttribute("error");
                 request.getSession().removeAttribute("customerId");
             request.getSession().removeAttribute("rank");
             request.logout();
          
        } catch (ServletException ex) {
            Logger.getLogger(LogoutCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
       return super.execute(request);    
    }
    
}
