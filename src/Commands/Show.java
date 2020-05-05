package Commands;

import FillCollection.HumanBeing;

/**
 * show all elements of collection
 *
 * @author Polina
 */
public class Show implements CommandWithoutArg {
    HumanCollection humans = new HumanCollection();
    String name = "show";
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

