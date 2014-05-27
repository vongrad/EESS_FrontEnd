package commands;

import dto.FirstVoteDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class FirstRoundStudentVoteInfoCommand extends TargetCommand {

    public FirstRoundStudentVoteInfoCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<FirstVoteDTO> votes = servlets.Factory.getInstance().getController().getFirstRoundVote();
        request.setAttribute("votes", votes);
        return super.execute(request);
    }

}
