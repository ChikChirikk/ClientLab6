package Commands;

import FillCollection.HumanBeing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class receiver contains collection and managing methods
 *
 * @author Diana
 * @author Polina
 */
public class HumanCollection implements Serializable {
    protected static ArrayList<HumanBeing> humans = new ArrayList<>();
    private Date dateCreation;

    public void setStream(Stream<HumanBeing> stream){
        humans = (ArrayList<HumanBeing>) stream.collect(Collectors.toList());
        stream.close();
    }
    public HumanCollection() {
        this.dateCreation = new Date();
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public ArrayList<HumanBeing> getArray() {
        return humans;
    }

    public void setArray(ArrayList array) {
        this.humans = array;
    }

    protected void removeHuman(String key) {
        this.humans.remove(key);
    }

    protected HumanBeing getHuman(int ind) {
        return this.humans.get(ind);
    }

    protected void removeHuman(int key) {
        this.humans.remove(key);
    }

    public int getSize() {
        return this.humans.size();
    }

    public void clear() {
        this.humans.clear();
    }

    public String getInfo() {
        return "Тип коллекции: ArrayList;\nKоличество элементов коллекции: " + this.getSize() + ";\nДата создания кол"
                + "лекции: " + this.getDateCreation() + ".";
    }

    public int findIndexOfElemById(int id) {
        int i = 0;
        for (HumanBeing human : humans) {
            if (human.getId() == id) return i;
            i++;
        }
        return (Integer) null;

    }

    public void addToCollection(HumanBeing human) {
        humans.add(human);
    }

    public void toSortArray() {
        TreeSet<HumanBeing> set = new TreeSet<>();
        for (HumanBeing human : humans) set.add(human);
        ArrayList<HumanBeing> temp = new ArrayList();
        for (HumanBeing human : set) temp.add(human);
        this.setArray(temp);
    }

}

