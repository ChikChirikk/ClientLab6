package Commands;

import FillCollection.HumanBeing;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Removes element by its id
 *
 * @author Diana
 */
public class Remove_by_id implements Commandable {
    HumanCollection humans = new HumanCollection();
    String name = "remove_by_id";
    public String getName() {
        return name;
    }
    /**
     * @param arg 's id
     * @return
     */
    public Object execute(Object arg) {
        try {
            int id = Integer.parseInt((String) arg);
            String ans = "Нет челика с таким id.";
            Iterator<HumanBeing> it = (Iterator<HumanBeing>) humans.getArray().iterator();
            while (it.hasNext()) {
                HumanBeing human = (HumanBeing) it.next();
                int humanId = (int) human.getId();
                if (id == humanId) {
                    it.remove();
                    ans = "Челик успешно удален";
                }
            }
            return (ans);
        } catch (NumberFormatException exp) {
			return ("Значение аргумента должно быть типа:\"long\".");

        }

    }
}
