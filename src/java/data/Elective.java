package data;

public class Elective {
    public String subject;
    public String proposedBy;

    public Elective(String Subject, String proposedBy) {
        this.subject = Subject;
        this.proposedBy = proposedBy;
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
}
