package commands;

import data.Elective;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class getElectivesCommand extends TargetCommand {

    public getElectivesCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
//        Collection<CustomerDTO> custs = servlets.Factory.getInstance().getBankController().getCustomers();
//        request.getSession().removeAttribute("error");
//        request.setAttribute("customers", custs);
        Collection<Elective> electives = servlets.Factory.getInstance().getController().getElectives();
        request.setAttribute("electives", electives);
        
        return super.execute(request);
    }

}
