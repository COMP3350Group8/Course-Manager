package comp3350group8.coursemanager.Business;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.ListItem;

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

    public int size() {
        return list.size();
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

    public ListItem get(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    }

    public ArrayList<ListItem> getAll() {
        return list;
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
