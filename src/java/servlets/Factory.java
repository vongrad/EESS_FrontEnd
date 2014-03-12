package servlets;



import commands.Command;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;




public class Factory {

  

    private static Factory instance = new Factory();
    private Map<String, Command> commands = new HashMap<>();
 
    private Factory() {
        ////mains
     // Create Commands here
        ///// Create a command with main, wich will be index page
    }

    public static Factory getInstance() {
        return instance;
    }


    public Command getCommand(String cmdStr, HttpServletRequest res) {
       if (cmdStr == null) {
            cmdStr =  "main" ;
        }
        System.out.println(cmdStr);
//        return commands.get(cmdStr);
//        if (cmdStr == null) {
//            cmdStr = "logIn";
//        }
        Command cmd = commands.get(cmdStr);

        //This is the most important place in terms of security
        //If you fail here your security is broken
       
        return cmd;
    }

  

  

}
