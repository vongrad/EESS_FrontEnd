package servlets;

import commands.Command;
import commands.LogInCommand;
import commands.LogoutCommand;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Controller", urlPatterns = {"/EESS_FrontEnd"})
public class Controller extends HttpServlet {


  private int PORT_NON_SSL;
 private int PORT_SSL;
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String cmdStr = request.getParameter("command");
    Command command = Factory.getInstance().getCommand(cmdStr,request);
    String path = command.execute(request);
    //request.getRequestDispatcher(path).forward(request, response);
    
    if (command instanceof LogInCommand ) {
        
     String SSL = "https://" + request.getServerName() + ":" + PORT_SSL +request.getRequestURI()+"?command=logInS";
     response.sendRedirect(SSL);
  } 
    
    else if(command instanceof LogoutCommand) {
      String nonSSL = "http://" + request.getServerName() + ":" + PORT_NON_SSL + request.getRequestURI();
      response.sendRedirect(nonSSL);
    }
    
    else {
      request.getRequestDispatcher(path).forward(request, response);
    }
    

  }

  @Override
  public void init() throws ServletException {
    PORT_NON_SSL = Integer.parseInt(getServletContext().getInitParameter("portNonSSL"));
    PORT_SSL = Integer.parseInt(getServletContext().getInitParameter("portSSL"));
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
