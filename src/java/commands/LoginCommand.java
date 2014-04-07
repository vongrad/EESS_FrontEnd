package commands;

import dto.ElectiveFirstDTO;
import dto.StudentDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class LoginCommand extends TargetCommand {

    public LoginCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        Collection<StudentDTO> students = servlets.Factory.getInstance().getController().getStudents();
        String cpr = request.getParameter("cpr");
        String password = request.getParameter("password");
        if (cpr != null) {
            for (StudentDTO s : students) {
                if (cpr.equals(s.getCpr())) {
                    request.getSession().setAttribute("student", s);
                    request.setAttribute("command", "main");
                    System.out.println("Login success");
                    return super.execute(request);
                }
            }
        }
        return super.execute(request);
    }

}
