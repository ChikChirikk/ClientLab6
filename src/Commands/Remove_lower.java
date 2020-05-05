package Commands;

/**
 * Removes all movies from collection
 *
 * @author Diana
 */
public class Remove_lower implements CommandWithoutArg, CommandWithObject {
    String whyFailed;
    HumanCollection humans = new HumanCollection();
    String name = "remove_lower";

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

    @Override
    public boolean check(String arg) {
        return false;
    }

    @Override
    public String whyFailed() {
        return whyFailed;
    }
}
