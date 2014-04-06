package commands;

import dto.ElectiveDTO;
import dto.FirstVoteDTO;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import servlets.Factory;

public class SuggestElectiveCommand extends TargetCommand {

    public SuggestElectiveCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        if (title != null || description != null) {
            request.setAttribute("info", "Elective added");
            ElectiveDTO elective = new ElectiveDTO(title, description, new Date(), "0");
            Factory.getInstance().getController().addElective(elective);
        } else {
            request.setAttribute("info", "Add elective");
           // Factory.getInstance().getController().g
        };
        return super.execute(request);
    }

}
