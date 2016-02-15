package comp3350group8.coursemanager;

/**
 * Created by Ian Smith on 2016-02-11.
 */
public interface AppDatabase {
    public void insert(ListItem item);
    public void update(int id, ListItem item);
    public ListItem remove(int id);
}
