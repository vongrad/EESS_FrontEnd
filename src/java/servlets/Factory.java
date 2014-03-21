package servlets;

import commands.Command;
import commands.GetElectivesCommand;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class Factory {
    
    private static Factory instance;
    private static DummyController controller;
    
    private Map<String, Command> commands;
    
    private Factory() {
        controller = new DummyController();
        commands = new HashMap<>();
        commands.put("main", new GetElectivesCommand("/jsp/main.jsp"));
    }

    public static Factory getInstance() {
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }
    
    public DummyController getController(){
        return controller;
    }

    public Command getCommand(String cmdStr, HttpServletRequest res) {
       if (cmdStr == null) {
            cmdStr =  "main";
        }
       
        Command cmd = commands.get(cmdStr);
        return cmd;
    }

  

  

}
