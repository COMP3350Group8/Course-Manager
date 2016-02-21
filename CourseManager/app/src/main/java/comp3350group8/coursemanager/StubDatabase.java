package comp3350group8.coursemanager;

import java.util.ArrayList;

import comp3350group8.coursemanager.AppDatabase;
import comp3350group8.coursemanager.ListItem;

/**
 * Created by Ian Smith on 2016-02-12.
 */
public class StubDatabase implements AppDatabase {
    private ArrayList<ListItem> list;

    public StubDatabase() {
        list = new ArrayList<ListItem>();
    }

    public void insert(ListItem item) {
        list.add(item);
    }

    public void update(int id, ListItem item) {
        ListItem o = list.get(id);
        list.add(id, item);
    }

    public ListItem remove(int id) {
        return list.remove(id);
    }

    public String[] read() {
        String[] array = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i).toString();
        }

        return array;
    }
}
