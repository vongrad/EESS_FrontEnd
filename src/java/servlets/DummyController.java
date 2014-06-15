package servlets;

import dto.ElectiveDTO;
import dto.ElectiveFirstDTO;
import dto.ElectiveSecondDTO;
import dto.FirstVoteDTO;
import dto.SecondVoteDTO;
import dto.SkillDTO;
import dto.StudentDTO;
import dto.StudentElectiveDTO;
import dto.TeacherDTO;
import ejb.DBManagerRemote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DummyController implements DBManagerRemote {

    private final Collection<ElectiveDTO> electives;
    private final Collection<StudentDTO> students;
    private final Collection<SkillDTO> skills;
    private final Collection<TeacherDTO> teachers;
    private Collection<ElectiveFirstDTO> firstRoundElectives;
    private Collection<FirstVoteDTO> firstVote;
    private Collection<ElectiveDTO> suggestedElectives;

    public DummyController() {
        electives = new ArrayList();
        students = new ArrayList();
        skills = new ArrayList();
        teachers = new ArrayList();
        firstRoundElectives = new ArrayList();
        firstVote = new ArrayList();
        suggestedElectives = new ArrayList();

        //Create Students
        StudentDTO s1 = new StudentDTO("Emil", "First", "11111");
        StudentDTO s2 = new StudentDTO("Emil", "Second", "22222");
        StudentDTO s3 = new StudentDTO("Emil", "Third", "33333");
        StudentDTO s4 = new StudentDTO("Emil", "Fourth", "44444");
        StudentDTO s5 = new StudentDTO("Emil", "Fifth", "55555");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        //Create Teacher Skills
        SkillDTO sk1 = new SkillDTO(0, "Mathemathics");
        SkillDTO sk2 = new SkillDTO(1, "Physics");
        SkillDTO sk3 = new SkillDTO(2, "Literature");
        SkillDTO sk4 = new SkillDTO(3, "Modern functional languages");
        SkillDTO sk5 = new SkillDTO(4, "Artificial Intelligence");
        skills.add(sk1);
        skills.add(sk2);
        skills.add(sk3);
        skills.add(sk4);
        skills.add(sk5);

        //Create Teachers
        TeacherDTO t1 = new TeacherDTO("000000", "Teacher", "One", skills);
        TeacherDTO t2 = new TeacherDTO("111111", "Teacher", "Two", skills);
        TeacherDTO t3 = new TeacherDTO("222222", "Teacher", "Three", skills);
        TeacherDTO t4 = new TeacherDTO("333333", "Teacher", "Four", skills);
        TeacherDTO t5 = new TeacherDTO("444444", "Teacher", "Fice", skills);
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);
        teachers.add(t5);

        //Create electives
        ElectiveDTO e1 = new ElectiveDTO(0, "Elective one", "Learn about elective one", new Date(), "0", t1);
        ElectiveDTO e2 = new ElectiveDTO(1, "Elective two", "Learn about elective two", new Date(), "1", t2);
        ElectiveDTO e3 = new ElectiveDTO(2, "Elective three", "Learn about elective three", new Date(), "0", t3);
        ElectiveDTO e4 = new ElectiveDTO(3, "Elective four", "Learn about elective four", new Date(), "0", t4);
        ElectiveDTO e5 = new ElectiveDTO(4, "Elective five", "Learn about elective five", new Date(), "0", t5);
        electives.add(e1);
        electives.add(e2);
        electives.add(e3);
        electives.add(e4);
        electives.add(e5);

        //Create first round electives
        ElectiveFirstDTO ef1 = new ElectiveFirstDTO(e1.getElectiveID(), e1.getTitle(), e1.getDescription(), e1.getDate(), e1.getProposed(), 2, 2, e1.getTeacher());
        ElectiveFirstDTO ef2 = new ElectiveFirstDTO(e2.getElectiveID(), e2.getTitle(), e2.getDescription(), e2.getDate(), e2.getProposed(), 2, 2, e2.getTeacher());
        ElectiveFirstDTO ef3 = new ElectiveFirstDTO(e3.getElectiveID(), e3.getTitle(), e3.getDescription(), e3.getDate(), e3.getProposed(), 2, 2, e3.getTeacher());
        ElectiveFirstDTO ef4 = new ElectiveFirstDTO(e4.getElectiveID(), e4.getTitle(), e4.getDescription(), e4.getDate(), e4.getProposed(), 2, 2, e4.getTeacher());
        ElectiveFirstDTO ef5 = new ElectiveFirstDTO(e5.getElectiveID(), e5.getTitle(), e5.getDescription(), e5.getDate(), e5.getProposed(), 2, 2, e5.getTeacher());
        firstRoundElectives.add(ef1);
        firstRoundElectives.add(ef2);
        firstRoundElectives.add(ef3);
        firstRoundElectives.add(ef4);
        firstRoundElectives.add(ef5);

        FirstVoteDTO fv1 = new FirstVoteDTO(s1, e1, e2, e3, e4);
        FirstVoteDTO fv2 = new FirstVoteDTO(s2, e2, e3, e4, e5);
        FirstVoteDTO fv3 = new FirstVoteDTO(s3, e3, e4, e5, e1);
        FirstVoteDTO fv4 = new FirstVoteDTO(s4, e4, e5, e1, e2);
        FirstVoteDTO fv5 = new FirstVoteDTO(s5, e5, e1, e2, e3);
        firstVote.add(fv1);
        firstVote.add(fv2);
        firstVote.add(fv3);
        firstVote.add(fv4);
        firstVote.add(fv5);
    }

    public Collection<ElectiveDTO> getElectives() {
        return electives;
    }

    @Override
    public void addThings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<StudentDTO> getStudents() {
        return students;
    }

    @Override
    public Collection<TeacherDTO> getTeachers() {
        return teachers;
    }

    @Override
    public Collection<ElectiveDTO> getSuggestedElectives() {
        return electives;
    }

    @Override
    public Collection<ElectiveFirstDTO> getFirstRndElectives() {
        return firstRoundElectives;
    }

    @Override
    public Collection<ElectiveSecondDTO> getSecondRndElectivesA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<ElectiveSecondDTO> getSecondRndElectivesB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<FirstVoteDTO> getFirstRoundVote() {
        return firstVote;
    }

    @Override
    public Collection<SecondVoteDTO> getSecondRoundVote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addElective(ElectiveDTO elective) {
        return electives.add(elective);
    }

    @Override
    public boolean removeElective(int electiveId) {
        for (ElectiveDTO e : electives) {
            if (e.getElectiveID() == electiveId) {
                return electives.remove(e);
            }
        }
        return false;
    }

    @Override
    public boolean addFirstRndStudentChoice(FirstVoteDTO firstRound) {
        return firstVote.add(firstRound);
    }

    @Override
    public boolean addSecondRndStudentChoice(SecondVoteDTO secondRound) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setTaughtElectives(int[] electiveId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean assignStudentElectives(Collection<StudentElectiveDTO> studentEle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isTaught(int electiveId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isApproved(int electiveId) {
        for (ElectiveDTO e : electives) {
            if (e.getElectiveID() == electiveId) {
                return "1".equals(e.getProposed());
            }
        }
        return false;
    }

    @Override
    public boolean objectExistsInDb(Class c, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean approveElective(int[] electiveIds) {
        for (ElectiveDTO e : electives) {
            for (int id : electiveIds) {
                if (e.getElectiveId() == id) {
                    e.setProposed("1");
                }
            }
        }
        return true;
    }

    @Override
    public boolean isElective(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void restoreVoteTables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
