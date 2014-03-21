package servlets;

import data.Elective;
import data.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DummyController {

    public List<Elective> electives;
    public List<Student> students;

    public DummyController() {
        electives = new ArrayList();
        students = new ArrayList();
        Student s1 = new Student("Emil 1");
        Student s2 = new Student("Emil 2");
        Student s3 = new Student("Emil 3");
        Student s4 = new Student("Emil 4");
        Student s5 = new Student("Emil 5");
        electives.add(new Elective("Artificial Intelligence", "Foo"));
        electives.add(new Elective("CSharp", "Torben"));
        electives.add(new Elective("Python", "Anders"));
        electives.add(new Elective("PHP", "Adrian"));
        electives.add(new Elective("Free time, do notinh", "Emil"));
        electives.get(1).votePrimary(s1);
        electives.get(1).votePrimary(s2);
        electives.get(1).votePrimary(s3);
        electives.get(3).votePrimary(s4);
        electives.get(3).voteSecondary(s1);
        students.add(s5);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s1);
    }

    public Collection<Elective> getElectives() {
        return electives;
    }

    public List<Student> getStudents() {
        return students;
    }

}
