package commands;

import javax.servlet.http.HttpServletRequest;
import data.SecurityRole;

public class TargetCommand implements Command {
private final String target;
    private final SecurityRole role;

    public SecurityRole getRole() {
        return role;
    }

    public TargetCommand(String target, SecurityRole role) {
        this.target = target;
        this.role = role;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return target;
    }
    
}
