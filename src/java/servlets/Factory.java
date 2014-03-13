package servlets;



import commands.Command;
import commands.TargetCommand;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;




public class Factory {

  

    private static Factory instance = new Factory();
    private Map<String, Command> commands = new HashMap<>();
 
    private Factory() {
        ////mains
     // Create Commands here
        commands.put("main", new TargetCommand("main.jsp"));
        ///// Create a command with main, wich will be index page
    }

    public static Factory getInstance() {
        return instance;
    }


    public Command getCommand(String cmdStr, HttpServletRequest res) {
       if (cmdStr == null) {
            cmdStr =  "main" ;
        }

        Command cmd = commands.get(cmdStr);
       
        return cmd;
    }

  

  

}
