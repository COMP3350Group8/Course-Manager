package comp3350group8.coursemanager.Business;

import java.util.ArrayList;

/**
 * Uses the Strategy Pattern to take in ArrayLists and return a String array
 * Created by Ian Smith on 2016-03-28.
 */
public class ArrayConverter {
    public static String[] convertCourses(ArrayList<Course> courses) {
        ArrayList<ListItem> list = new ArrayList<ListItem>();

        for (int i = 0; i < courses.size(); i++) {
            list.add((ListItem)courses.get(i));
        }

        return convertListItems(list);
    }

    public static String[] convertTasks(ArrayList<Task> tasks) {
        //convert to an ArrayList of ListItems
        ArrayList<ListItem> list = new ArrayList<ListItem>();

        for (int i = 0; i < tasks.size(); i++) {
            list.add((ListItem)tasks.get(i));
        }

        return convertListItems(list);
    }

    public static String[] convertListItems(ArrayList<ListItem> list) {
        String[] output = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i).getName();
        }

        return output;
    }
}
