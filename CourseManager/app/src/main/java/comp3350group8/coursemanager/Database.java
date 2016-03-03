package comp3350group8.coursemanager;

/**
 * Created by Ian Smith on 2016-03-02.
 */
public interface Database {
    public void insert(ListItem item);
    public void update(int id, ListItem item);
    public ListItem remove(int id);
    public String[] read();
    public void destroy();
}
