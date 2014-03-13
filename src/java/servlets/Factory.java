package servlets;

import commands.Command;
import commands.getElectivesCommand;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class Factory {
    
    private static Factory instance = new Factory();
    private Map<String, Command> commands = new HashMap<>();
    private static DummyController controller = new DummyController();
    
    private Factory() {
        commands.put("main", new getElectivesCommand("/main.jsp"));
    }

    public static Factory getInstance() {
        return instance;
    }
    
    public DummyController getController(){
        return controller;
    }


    public Command getCommand(String cmdStr, HttpServletRequest res) {
       if (cmdStr == null) {
            cmdStr =  "main" ;
        }
        Command cmd = commands.get(cmdStr);
       
        return cmd;
    }

  

  

}
