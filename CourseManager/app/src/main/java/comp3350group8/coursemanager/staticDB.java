package comp3350group8.coursemanager;

import java.util.ArrayList;

/**
 * Created by David on 2016-02-22.
 */
public class staticDB {
    private static ArrayList<SubTable> db;

    // initializes the arraylist
    public static void init() {
        db = new ArrayList<SubTable>();
    }

    // creates a table with the supplied name
    public static void createTable(String name) {
        SubTable list = new SubTable(name);
        db.add(list);
    }

    // inserts a supplied item into the list indicated by name
    public static void insert(ListItem item, String name){
        for (int i = 0; i < db.size(); i++) {
            SubTable curr = db.get(i);

            if (curr.getName().equals(name)) {
                curr.insert(item);
            }
        }
    }

    // returns the item indicated by item
    public static ListItem query(ListItem item, String name) {
        // go through the list and find the sub-list with the name name
        for (int i = 0; i < db.size(); i++) {
            SubTable curr = db.get(i);
            
            if (curr.getName().equals(name)){
                return curr.getItem(item);
            }
        }

        return null;
    }

    // returns an array of strings representing the contents of the table
    public static String[] getTable(String name) {
        String[] out = null;

        for (int i = 0; i < db.size(); i++) {
            SubTable curr = db.get(i);

            if (curr.getName().equals(name)){
                return curr.toStringArray();
            }
        }
        out = new String[1];
        out[0] ="";

        return null;
    }

    // inserts item into the list at the supplied index (id)
    public static void update(ListItem item, int id, String name) {
        for (int i = 0; i < db.size(); i++) {
            SubTable curr = db.get(i);

            if (curr.getName().equals(name)) {
                curr.replace(item, id);
            }
        }
    }

    // prints the contents of the database
    public static void print() {
        for (int i = 0; i < db.size(); i++) {
            SubTable curr = db.get(i);

            System.out.println(curr);
        }
    }
}
