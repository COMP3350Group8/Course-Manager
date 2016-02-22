package comp3350group8.coursemanager;

import java.util.ArrayList;

/**
 * Created by David on 2016-02-22.
 */
public class SubTable {
    private String name;
    private ArrayList<ListItem> list;

    public SubTable(String n) {
        name = n;
        list = new ArrayList<ListItem>();
    }

    public String getName() {return name;}

    public void insert(ListItem item) {
        list.add(item);
    }

    public ListItem getItem(ListItem item) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(item))
                return item;
        }

        return null;
    }

    public void replace(ListItem item, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (i == id) {
                list.add(id, item);
            }
        }
    }

    public String[] toStringArray() {
        String[] array = new String[list.size()];

        for (int i= 0; i < list.size(); i++) {
            array[i] = list.get(i).toString();
        }

        return array;
    }

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
