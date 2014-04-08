package commands;

import dto.ElectiveDTO;
import dto.ElectiveFirstDTO;
import dto.FirstVoteDTO;
import dto.StudentDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class GetElectivesCommand extends TargetCommand {

    public GetElectivesCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<ElectiveFirstDTO> electives = servlets.Factory.getInstance().getController().getFirstRndElectives();
        request.setAttribute("electives", electives);
        
        return super.execute(request);
    }

}
