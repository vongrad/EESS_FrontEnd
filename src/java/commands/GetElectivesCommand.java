package commands;

import data.Elective;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class GetElectivesCommand extends TargetCommand {

    public GetElectivesCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<Elective> electives = servlets.Factory.getInstance().getController().getElectives();
        request.setAttribute("electives", electives);

        return super.execute(request);
    }

}
