package servlets;

import commands.Command;
import commands.GetElectivesCommand;
import commands.GetStudentsCommand;
import commands.GetSuggestedElectives;
import commands.SuggestElectiveCommand;
import ejb.DBManagerRemote;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

public class Factory {
    DBManagerRemote dBManager = lookupDBManagerRemote();

    private static Factory instance;
    private static DummyController controller;

    private final Map<String, Command> commands;

    private Factory() {
        controller = new DummyController();
        commands = new HashMap<>();
        commands.put("main", new GetElectivesCommand("/jsp/main.jsp"));
        commands.put("getFirstRound", new GetStudentsCommand("/jsp/studentList.jsp"));
        commands.put("getSuggestedElectives", new GetSuggestedElectives("/jsp/electiveList.jsp"));
        commands.put("suggestElective", new SuggestElectiveCommand("/jsp/suggestElective.jsp"));
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

//    public DummyController getController() {
//        return controller;
//    }
    public DBManagerRemote getController(){
        return dBManager;
    }

    public Command getCommand(String cmdStr, HttpServletRequest res) {
        if (cmdStr == null) {
            cmdStr = "main";
        }

        Command cmd = commands.get(cmdStr);
        return cmd;
    }

    private DBManagerRemote lookupDBManagerRemote() {
        try {
            Context c = new InitialContext();
            return (DBManagerRemote) c.lookup("java:global/EESS_BackEnd/DBManager!ejb.DBManagerRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
