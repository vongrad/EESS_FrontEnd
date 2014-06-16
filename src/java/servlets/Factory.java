package servlets;

import commands.*;
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
    private static DBManagerRemote controller;

    private final Map<String, Command> commands;

    private Factory() {
        controller = new DummyController();
        commands = new HashMap<>();
        commands.put("index", new LoginCommand("/jsp/index.jsp"));
        commands.put("main", new GetElectivesCommand("/jsp/main.jsp"));
        commands.put("getFirstRound", new FirstRoundStudentVoteInfoCommand("/jsp/firstRound.jsp"));
        commands.put("getSecondRound", new SecondRoundStudentVoteInfoCommand("/jsp/secondRound.jsp"));
        commands.put("getSuggestedElectives", new GetSuggestedElectives("/jsp/electiveList.jsp"));
        commands.put("approveElective", new GetSuggestedElectives("/jsp/approveElective.jsp"));
        commands.put("suggestElective", new SuggestElectiveCommand("/jsp/suggestElective.jsp"));
        commands.put("firstRoundStudent", new FirstRoundStudentCommand("/jsp/firstRoundStudent.jsp"));
        commands.put("secondRoundStudent", new SecondRoundStudentCommand("/jsp/secondRoundStudent.jsp"));
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public DBManagerRemote getController(){
        // a bridge switch between DB and dummyData 
//        return dBManager; //db data controller
        return controller; //dummy data controller
    }

    public Command getCommand(String cmdStr, HttpServletRequest res) {
        if (cmdStr == null) {
            cmdStr = "index";
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
