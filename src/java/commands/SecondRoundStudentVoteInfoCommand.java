package commands;

import dto.SecondVoteDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class SecondRoundStudentVoteInfoCommand extends TargetCommand {

    public SecondRoundStudentVoteInfoCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<SecondVoteDTO> votes = servlets.Factory.getInstance().getController().getSecondRoundVote();
        request.setAttribute("votes", votes);
        return super.execute(request);
    }

}
