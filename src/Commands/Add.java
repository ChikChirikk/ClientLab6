package Commands;

/**
 * add new element in collection
 *
 * @author Polina
 */
public class Add implements CommandWithObject, CommandWithoutArg {
    HumanCollection humans = new HumanCollection();
    String name = "add";

    public String getName() {
        return name;
    }

    /**
     * @param arg ignore this
     * @return
     */
    public Object execute(Object arg) {
    	return null;
    }

    @Override
    public boolean check(String arg) {
        return true;
    }

    @Override
    public String whyFailed() {
        return null;
    }
}