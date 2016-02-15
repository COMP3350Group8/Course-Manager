package comp3350group8.coursemanager; /**
 * Created by Ian Smith on 2016-02-12.
 */
import junit.framework.TestCase;

public class TestStubDatabase extends TestCase {
    public void testStub() {
        AppDatabase database = new StubDatabase();
        assertNotNull(database);

        for (int i = 0; i < 10; i++) {
            System.out.println("Inserting " + i);
            IntAtom item = new IntAtom(i);
            database.insert(item);
        }

        database.update(0, new IntAtom(50));
        database.update(3, new IntAtom(100));

        for (int i = 0; i < 10; i++) {
            System.out.print("Removing item " + i + ": ");
            IntAtom out = (IntAtom)database.remove(0);
            System.out.println(out.getItem());
        }
    }
}
