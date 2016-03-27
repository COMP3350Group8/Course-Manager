package comp3350group8.coursemanager.DatabaseTests;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;
import android.util.Log;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.User;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;

/**
 * Created by Ian Smith on 2016-03-25.
 */
public class UserIntegrationTest extends AndroidTestCase {
    private SQLDatabase db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        Log.d("DEBUG", "Attempting to create database");
        db = new SQLDatabase(context);
//        db = new StubDatabase(context);
        
        testUserInsertion();
        testUserQuery();
        printUsers();
    }

    public void testUserInsertion() {
        User[] users = {new User("Ian", "car", "1", "smithi35", "umanitoba"), new User("David", "password", "2", "dowasi", "umanitoba"), new User("Graham", " ", "3", "gsilver", "umanitoba")};

        for (int i = 0; i < users.length; i++) {
            Log.d("DEBUG", "" + db.insertUser(users[i]));
        }
    }

    public void testUserQuery() {
        Log.d("DEBUG", "Attempting user query: " + db.getUser("smithi35", "car"));
    }

    public void printUsers() {
        ArrayList<User> users = db.getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            Log.d("DEBUG", "user " + i + ": " + users.get(i));
        }
    }

    @Override
    public void tearDown() throws Exception {
        Log.d("DEBUG", "Attempting to close database");
        db.close();
        super.tearDown();
    }

}
