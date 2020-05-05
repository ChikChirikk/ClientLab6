package Commands;

/**
 * add update element in collection by its id
 *
 * @author Polina
 */
public class Update implements CommandWithObject {
    static long arg;
    String whyFailed;
    HumanCollection humans = new HumanCollection();
    String name = "update";

    public String getName() {
        return name;
    }

    /**
     * @param hum id of element
     * @return
     */
    public Object execute(Object hum) {
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

