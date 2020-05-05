package Commands;

/**
 * show all commands
 *
 * @author Polina
 */

public class Help implements CommandWithoutArg {
    String name = "help";

    public String getName() {
        return name;
    }

    /**
     * @param arg ignore this
     * @return
     */
    @Override
    public Object execute(Object arg) {
        return null;

    }
}