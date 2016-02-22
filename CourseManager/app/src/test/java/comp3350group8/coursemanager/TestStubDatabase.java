package comp3350group8.coursemanager;
/**
 * Created by Ian Smith on 2016-02-12.
 */
import junit.framework.TestCase;

import comp3350group8.coursemanager.staticDB;

public class TestStubDatabase extends TestCase {
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
    }
}
