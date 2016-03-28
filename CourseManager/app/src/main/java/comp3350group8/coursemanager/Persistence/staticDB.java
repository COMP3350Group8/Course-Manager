package comp3350group8.coursemanager.Persistence;

import android.content.Context;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.ListItem;
import comp3350group8.coursemanager.Business.SubTable;

/**
 * Created by David on 2016-02-22.
 */
public class staticDB {
    private static SQLDatabase db;

    public static void init(Context c) {
        db = new SQLDatabase(c);
//        db = new StubDatabase(c);
    }

    public static SQLDatabase getDB() {
        return db;
    }

}