package comp3350group8.coursemanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Ian Smith on 2016-02-17.
 * needs to implement a database
 */
public class SQLDatabase  implements Database {
    private SQLiteDatabase db;
    private String name;
    private File dbFile;

    public SQLDatabase(String name) {
        this.name = name;
        String path = "//data/data/comp3350group8.coursemanager/databases/" + name;
        db = openOrCreateDatabase(name, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + name + "(value INT);");
        dbFile = new File(path);
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

    public String fetch() {
        Cursor resultSet = db.rawQuery("Select * from " + name, null);
        resultSet.moveToFirst();
        String out = resultSet.getString(1);
        resultSet.close();

        return out;
    }

    public void destroy() {
        db.deleteDatabase(dbFile);
    }
}
