package comp3350group8.coursemanager;

import java.util.ArrayList;

/**
 * Created by David on 2016-02-22.
 */
public class SubTable {
    private String name;
    private ArrayList<ListItem> list;

    // the constructor takes an argument for the name of the list only
    public SubTable(String n) {
        name = n;
        list = new ArrayList<ListItem>();
    }

    // returns the name of the list
    public String getName() {return name;}

    // inserts a ListItem into the list at the end
    public void insert(ListItem item) {
        list.add(item);
    }

    // retrieves the item if looking for a specific one
    public ListItem getItem(ListItem item) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(item))
                return item;
        }

        return null;
    }

    // places item in at list[id]
    public void replace(ListItem item, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (i == id) {
                list.add(id, item);
            }
        }
    }

    // returns an array of strings representing the contents of the list
    public String[] toStringArray() {
        String[] array = new String[list.size()];

        for (int i= 0; i < list.size(); i++) {
            array[i] = list.get(i).toString();
        }

        return array;
    }

    // returns a single string representing the list
    public String toString(){
        String out = name + ": ";
        String array = "[ ";

        for (int i = 0; i < list.size(); i++) {
            array = array + "" + list.get(i).toString() + ", ";
        }
        array = array + "]";
        return out + array;
    }
}
