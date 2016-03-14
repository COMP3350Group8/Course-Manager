package comp3350group8.coursemanager.Business;

import comp3350group8.coursemanager.ListItem;

/**
 * Created by Ian Smith on 2016-02-12.
 */
public class IntAtom extends ListItem {
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
        String out = "value INT";
        return out;
    }
}
