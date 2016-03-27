package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-02-12.
 */
public abstract class ListItem {
    private int _ID;

    public abstract String getName();
    public  void setID(int id) {_ID = id;}
    public abstract boolean equals(ListItem otherItem);
    public abstract String toString();
    public  int getID() {return _ID;}
}
