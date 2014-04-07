package commands;

import dto.ElectiveDTO;
import dto.FirstVoteDTO;
import dto.StudentDTO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class FirstRoundStudentCommand extends TargetCommand {

    public FirstRoundStudentCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<ElectiveDTO> electives = servlets.Factory.getInstance().getController().getSuggestedElectives();
        request.setAttribute("electives", electives);
        String A1 = request.getParameter("A1");
        String A2 = request.getParameter("A2");
        String B1 = request.getParameter("B1");
        String B2 = request.getParameter("B2");
        if (A1 != null || A2 != null || B1 != null || B2 != null) {
            ElectiveDTO firstPriority1 = null;
            ElectiveDTO firstPriority2 = null;
            ElectiveDTO secondPriority1 = null;
            ElectiveDTO secondPriority2 = null;
            for (ElectiveDTO e : electives) {
                if (e.getTitle().equals(A1)) {
                    firstPriority1 = new ElectiveDTO(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed(), e.getTeacher());
                } else if (e.getTitle().equals(A2)) {
                    firstPriority2 = new ElectiveDTO(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed(), e.getTeacher());
                } else if (e.getTitle().equals(B1)) {
                    secondPriority1 = new ElectiveDTO(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed(), e.getTeacher());
                } else if (e.getTitle().equals(B2)) {
                    secondPriority2 = new ElectiveDTO(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed(), e.getTeacher());
                }
            }
            Collection<StudentDTO> students = servlets.Factory.getInstance().getController().getStudents();
            StudentDTO student = null;
            for (StudentDTO s : students) {
                if (student == null) {
                    student = new StudentDTO(s.getFirstName(), s.getLastName(), s.getCpr());
                }
            }
            FirstVoteDTO choice = new FirstVoteDTO(student, firstPriority1, firstPriority2, secondPriority1, secondPriority2);
            servlets.Factory.getInstance().getController().addFirstRndStudentChoice(choice);
        }
        return super.execute(request);
    }

}
