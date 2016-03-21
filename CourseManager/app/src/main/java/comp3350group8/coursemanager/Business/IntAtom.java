package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-02-12.
 */
public class IntAtom extends ListItem {
    private int _ID = 0;
    private int item;

    public IntAtom(int q) {
        item = q;
    }

    public int getItem() {
        return item;
    }

    public boolean equals(ListItem otherItem) {
        boolean equal = false;

        if (otherItem instanceof IntAtom) {
            IntAtom other = (IntAtom) otherItem;
            int q = other.item;

            equal = item == q;
        }

        return equal;
    }

    public String toString() {
        return "" + item;
    }

    public String getAttributes() {
        return "value INT";
    }

    public int getID() {return _ID;}
    public void setID(int id) {_ID = id;}
}
