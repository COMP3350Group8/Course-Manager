package comp3350group8.coursemanager;

import android.database.sqlite.SQLiteDatabase;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Ian Smith on 2016-02-17.
 * needs to implement a database
 */
public class SQLDatabase  implements Database {
    private SQLiteDatabase db;
    private String name;

    public SQLDatabase(String name) {
        this.name = name;
        db = openOrCreateDatabase(name, null);
    }

    public void insert(ListItem item) {
        String stringified = item.toString();
        db.execSQL("INSERT INTO " + name + " VALUES(" + stringified + ");");
    }

    public void update(int id, ListItem item) {

    }

    public ListItem remove(int id) {
        return null;
    }

    public String[] read() {
        return null;
    }

    public void destroy() {
        //db.deleteDatabase();
    }
}
