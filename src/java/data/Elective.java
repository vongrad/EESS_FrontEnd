package data;

import java.util.ArrayList;
import java.util.List;

public class Elective {

    public String subject;
    public String proposedBy;
    public ArrayList<Student> primary, secondary;

    public Elective(String Subject, String proposedBy) {
        this.subject = Subject;
        this.proposedBy = proposedBy;
        primary = new ArrayList();
        secondary = new ArrayList();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String Subject) {
        this.subject = Subject;
    }

    public String getProposedBy() {
        return proposedBy;
    }

    public void votePrimary(Student s) {
        primary.add(s);
        s.setPrimary(this);
    }

    public void voteSecondary(Student s) {
        secondary.add(s);
        s.setSecondary(this);
    }

    public void deletePrimary(Student s) {
        primary.remove(s);
        s.setPrimary(null);
    }

    public void deleteSecondary(Student s) {
        secondary.remove(s);
        s.setSecondary(null);
    }

    public ArrayList<Student> getPrimary() {
        return primary;
    }

    public List<Student> getSecondary() {
        return secondary;
    }

}
