package comp3350group8.coursemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Ian Smith on 2016-02-17.
 * needs to implement a database
 */
public class SQLDatabase  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Whole Database";

    public SQLDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_INIT_TABLE = "CREATE TABLE ints ( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Value INT)";

        // coluumns are ID and Value for table ints
        db.execSQL(CREATE_INIT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Init");

        this.onCreate(db);
    }

    private static final String TABLE_INTS = "ints";

    // ints table columns
    private static final String KEY_ID = "ID";
    private static final String KEY_VALUE = "Value";
    private static final String[] COLUMNS = {KEY_ID, KEY_VALUE};

    // CRUD methods

    // insert parameter into the database
    public void insert(IntAtom item) {
        // get reference to writable db
        SQLiteDatabase db = this.getWritableDatabase();

        // get content values
        ContentValues values = new ContentValues();
        values.put(KEY_VALUE, item.getItem()); // get value

        db.insert(TABLE_INTS, null, values);

        db.close();
    }

    public IntAtom getInt(int id) {
        IntAtom atom = null;

        if (id > 0) {
            SQLiteDatabase db = this.getReadableDatabase();

            // build query
            Cursor cursor =
                    db.query(TABLE_INTS, COLUMNS, " id = ?", new String[]{String.valueOf(id)}, null, null, null, null);

            boolean successful = cursor.moveToFirst();
            Log.d("GetInt", "" + successful);

            if (successful) {
                atom = new IntAtom(Integer.parseInt(cursor.getString(0)));
            }
            cursor.close();
        }

        return atom;
    }

    public ArrayList<IntAtom> getAllInts() {
        ArrayList<IntAtom> list = new ArrayList<IntAtom>();

        String query = "SELECT * FROM " + TABLE_INTS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        IntAtom atom = null;

        if (cursor.moveToFirst()) {
            do {
                atom = new IntAtom(Integer.parseInt(cursor.getString(1)));
                Log.d("list", atom.toString());
                list.add(atom);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

}
