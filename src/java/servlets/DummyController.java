package servlets;

import data.Elective;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DummyController {

    public List<Elective> electives;

    public DummyController() {
        electives = new ArrayList();
        
        electives.add(new Elective("Artificial Intelligence", "Foo"));
        electives.add(new Elective("C#", "Torbet"));
        electives.add(new Elective("Python", "Anders"));
        electives.add(new Elective("PHP", "Adrian"));
        electives.add(new Elective("Free time, do notinh", "Emil"));
    }

    public Collection<Elective> getElectives() {
        return electives;
    }

}
