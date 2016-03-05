package comp3350group8.coursemanager;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

/**
 * Created by Ian Smith on 2016-03-05.
 */
public class SQLiteTest extends AndroidTestCase {
    private SQLDatabase db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        db = new SQLDatabase(context);
        testInsertion();
        testQuery();
    }

    @Override
    public void tearDown() throws Exception {
        db.close();
        super.tearDown();
    }

    //@Test
    public void testInsertion() {
        for (int i = 0; i < 10; i++) {
            IntAtom c = new IntAtom(i);
            db.insert(c);
        }
    }

    public void testQuery() {
        System.out.println(db.getInt(1));
    }
}
