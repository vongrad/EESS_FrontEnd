/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hsty
 */
public interface Command {

    String execute(HttpServletRequest request);
    
}
