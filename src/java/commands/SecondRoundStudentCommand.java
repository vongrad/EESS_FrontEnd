package commands;

import dto.ElectiveDTO;
import dto.ElectiveSecondDTO;
import dto.SecondVoteDTO;
import dto.StudentDTO;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

public class SecondRoundStudentCommand extends TargetCommand {

    public SecondRoundStudentCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<ElectiveSecondDTO> electivesA = servlets.Factory.getInstance().getController().getSecondRndElectivesA();
        Collection<ElectiveSecondDTO> electivesB = servlets.Factory.getInstance().getController().getSecondRndElectivesB();
        Collection<StudentDTO> students = new ArrayList();
        Collection<SecondVoteDTO> secondRound = servlets.Factory.getInstance().getController().getSecondRoundVote();
        for (StudentDTO student : servlets.Factory.getInstance().getController().getStudents()) {
            boolean check = false;
            for (SecondVoteDTO vote : secondRound) {
                if (student.getCpr().equals(vote.getStudent().getCpr())) {
                    check = true;
                }
            }
            if (!check) {
                students.add(new StudentDTO(student.getFirstName(), student.getLastName(), student.getCpr()));
            }
        }
        System.out.println(students.size());
        request.setAttribute("electivesA", electivesA);
        request.setAttribute("electivesB", electivesB);
        request.setAttribute("students", students);
        String A1 = request.getParameter("A1");
        String A2 = request.getParameter("A2");
        String B1 = request.getParameter("B1");
        String B2 = request.getParameter("B2");
        if (A1 != null || A2 != null || B1 != null || B2 != null) {
            ElectiveDTO firstPriority1 = null;
            ElectiveDTO firstPriority2 = null;
            ElectiveDTO secondPriority1 = null;
            ElectiveDTO secondPriority2 = null;
            for (ElectiveDTO e : electivesA) {
                if (e.getTitle().equals(A1)) {
                    firstPriority1 = new ElectiveDTO(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed(), e.getTeacher());
                } else if (e.getTitle().equals(A2)) {
                    firstPriority2 = new ElectiveDTO(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed(), e.getTeacher());
                }
            }
            for (ElectiveDTO e : electivesB) {
                if (e.getTitle().equals(B1)) {
                    secondPriority1 = new ElectiveDTO(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed(), e.getTeacher());
                } else if (e.getTitle().equals(B2)) {
                    secondPriority2 = new ElectiveDTO(e.getElectiveID(), e.getTitle(), e.getDescription(), e.getDate(), e.getProposed(), e.getTeacher());
                }
            }
            StudentDTO student = null;

            for (StudentDTO s : students) {
                if (s.getCpr().equals(request.getParameter("studentId"))) {
                    student = new StudentDTO(s.getFirstName(), s.getLastName(), s.getCpr());
                    System.out.println(s.getFirstName());
                    System.out.println(request.getParameter("studentId"));
                }
            }
            SecondVoteDTO choice = new SecondVoteDTO(firstPriority1, firstPriority2, secondPriority1, secondPriority2, student);
            servlets.Factory.getInstance().getController().addSecondRndStudentChoice(choice);
        }
        return super.execute(request);
    }

}
