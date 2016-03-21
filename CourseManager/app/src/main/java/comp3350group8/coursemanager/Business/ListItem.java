package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-02-12.
 */
public abstract class ListItem {
    private int _ID;
    public abstract boolean equals(ListItem otherItem);
    public abstract String toString();
    public abstract void setID(int id);
    public abstract int getID();
}
