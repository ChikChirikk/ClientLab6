package Commands;

/**
 * Removes all movies from collection
 * @author Polina
 */
public class Clear implements CommandWithoutArg {
	HumanCollection humans = new HumanCollection();
	String name = "clear";
	public String getName() {
		return name;
	}
    /**
	 * @param arg ignore this
	 * @return
	 */
	public Object execute(Object arg){
		return null;

	}
}