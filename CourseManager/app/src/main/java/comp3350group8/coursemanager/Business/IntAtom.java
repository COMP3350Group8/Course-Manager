package comp3350group8.coursemanager.Business;

import android.content.ContentValues;

/**
 * Created by Ian Smith on 2016-02-12.
 */
public class IntAtom extends ListItem {
    private int _ID = 0;
    private int item;

    public IntAtom() {item = 0;}
    public IntAtom(int q) {
        item = q;
    }

    public int getItem() {
        return item;
    }
    public void setItem(int i) {item = i;}

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

    private static final String[] INTS_COLUMNS = {"ID", "Value"};
    private static final String Table_SQL = "CREATE TABLE ints ( " +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " Value INT)";
    private static final String TABLE_NAME = "ints";

    public static String[] getColumns() {return INTS_COLUMNS;}
    public static String getTableSQL() {return Table_SQL;}
    public static String getTableName() {return TABLE_NAME;}

    public ContentValues getValues() {
        ContentValues values = new ContentValues();
        values.put(INTS_COLUMNS[1], item); // get value

        return values;
    }

    public int getID() {return _ID;}
    public void setID(int id) {_ID = id;}
}
