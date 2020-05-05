package Commands;

import java.util.ArrayList;
/**
 * shows the last 5 commands
 * @author Diana
 */
public class History implements CommandWithoutArg {
    static ArrayList history = new ArrayList();
    String name = "history";
    /**
     * @param arg ignore this
     */
    public Object execute(Object arg) {
        return null;
    }
    public void addToHistory(String commandName){
    }
    @Override
    public String getName() {
        return name;
    }

}
