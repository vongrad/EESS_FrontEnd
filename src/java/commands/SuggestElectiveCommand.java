package commands;

import dto.ElectiveDTO;
import dto.TeacherDTO;
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
        String teacherID = request.getParameter("teacher");

        Collection<TeacherDTO> teachers = Factory.getInstance().getController().getTeachers();
        request.setAttribute("teachers", teachers);
        if (title != null || description != null) {
            if (!title.equals("") || !description.equals("")) {
                request.setAttribute("info", "Elective added");
                TeacherDTO teacher = null;
                for (TeacherDTO t : teachers) {
                    if (t.getCPR().equals(teacherID)) {
                        teacher = new TeacherDTO(t.getCPR(), t.getFirstName(), t.getLastName(), t.getSkills());
                    }
                }
//                ElectiveDTO elective = new ElectiveDTO(999, title, description, new Date(), "0", teacher);
                ElectiveDTO elective = new ElectiveDTO(title, description, new Date(), "0", teacher);
                Factory.getInstance().getController().addElective(elective);
            } else {
                request.setAttribute("info", "I fuckin hate java");
            }
        } else {
            request.setAttribute("info", "Add elective");
        };
        return super.execute(request);
    }

}
