package comp3350group8.coursemanager.BusinessTests;
import comp3350group8.coursemanager.Business.User;

import android.util.Log;

import junit.framework.TestCase;

import comp3350group8.coursemanager.Business.IntAtom;

/**
 * Created by Ian Smith on 2016-03-13.
 */
public class UserTest extends TestCase {
    public void testUser() {
        Log.d("DEBUG", "Testing user class");

        User[] users = {new User("Ian", "car", 789, "smithi35", "umanitoba"), new User("David", "password", 123, "dowasi", "umanitoba"), new User("Graham", " ", 456, "gsilver", "umanitoba")};
        assertNotNull(users[0]);
        assertNotNull(users[1].getEmail());
        assertNotNull(users[2].getName());
        assertNotNull(users[0].getPassWord());
        assertNotNull(users[1].getSchool());
        assertNotNull(users[2].getStudentNum());
        assertFalse(users[2].equals(users[1]));
        assertTrue(users[2].equals(users[2]));
        assertFalse(users[2].equals(new IntAtom(3)));

        for (int i = 0; i < users.length; i++) {
            Log.d("DEBUG", "i = " + i + ", " + users[i].toString());
        }
    }
}
