package commands;

import dto.ElectiveDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class GetSuggestedElectives extends TargetCommand {

    public GetSuggestedElectives(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String electiveId = request.getParameter("electiveId");
        if (electiveId != null) {
            int[] id = {Integer.parseInt(electiveId)};
            servlets.Factory.getInstance().getController().approveElective(id);
        };
        Collection<ElectiveDTO> electives = servlets.Factory.getInstance().getController().getSuggestedElectives();
        request.setAttribute("electives", electives);
        return super.execute(request);
    }

}
