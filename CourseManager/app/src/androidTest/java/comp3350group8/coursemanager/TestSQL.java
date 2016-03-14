package comp3350group8.coursemanager;

import junit.framework.TestCase;

import comp3350group8.coursemanager.Business.IntAtom;
import comp3350group8.coursemanager.Persistence.SQLDatabase;

/**
 * Created by Ian Smith on 2016-03-02.
 */
public class TestSQL extends TestCase {
    public void testCase() {
        SQLDatabase q = new SQLDatabase(null);

        IntAtom c = new IntAtom(0);
        q.insertInt(c);
    }
}
