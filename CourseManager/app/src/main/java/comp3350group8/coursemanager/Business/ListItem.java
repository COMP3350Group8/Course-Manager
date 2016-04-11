package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-02-12.
 */
public abstract class ListItem {
    private int _ID;

    public  void setID(int id) {_ID = id;}
    public  int getID() {return _ID;}

    protected String getString(String s) {
        String out = "";
        if (s != null) {
            if (!s.equals("")) {
                out = s;
            } else {
                out = null;
            }
        } else {
            out = null;
        }

        return out;
    }

    public abstract String getName();
    public abstract boolean equals(ListItem otherItem);
    public abstract String toString();
}
