package comp3350group8.coursemanager;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ian Smith on 2016-03-05.
 */
public class SQLiteTest extends AndroidTestCase {
    private SQLDatabase db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        Log.d("DEBUG", "Attempting to create database");
        db = new SQLDatabase(context);
        testInsertion();
        testRetrieval();
        testQuery();
    }

    //@Test
    public void testInsertion() {
        for (int i = 0; i < 10; i++) {
            IntAtom c = new IntAtom(i);
            Log.d("DEBUG", "Attempting to insert " + i);
            db.insert(c);
        }
    }

    public void testRetrieval() {
        Log.d("DEBUG", "Attempting total recall");
        ArrayList<IntAtom> list = db.getAllInts();

        for (int i = 0; i < list.size(); i++) {
            Log.d("DEBUG", "" + list.get(i));
        }
    }

    public void testQuery() {
        Log.d("DEBUG", "Attempted query: " + db.getInt(1));
    }

    @Override
    public void tearDown() throws Exception {
        Log.d("DEBUG", "Attempting to close database");
        db.close();
        super.tearDown();
    }
}
