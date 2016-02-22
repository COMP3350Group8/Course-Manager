package comp3350group8.coursemanager;

import junit.framework.TestCase;
import comp3350group8.coursemanager.staticDB;

/**
 * Created by Ian Smith on 2016-02-22.
 */
public class TestDB extends TestCase {

    public void testStub() {
        staticDB.init();

        for (int i = 0; i < 10; i++) {
            staticDB.createTable("" + i);
        }

        for (int i = 0; i < 1000; i++) {
            staticDB.insert(new IntAtom(i), "" + (i % 10));
        }

        for (int i = 0; i < 10; i++) {
            String[] array = staticDB.getTable("" + i);
            assertNotNull(array);
        }

        staticDB.update(new IntAtom(70), 0, "0");
        staticDB.update(new IntAtom(70), 2, "6");
        staticDB.update(new IntAtom(70), 10, "6");

        assertNotNull(staticDB.query(new IntAtom(70), "6"));

        staticDB.print();
    }
}
