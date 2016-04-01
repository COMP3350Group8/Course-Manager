package comp3350group8.coursemanager.DatabaseTests;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;
import android.util.Log;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentUser;
import comp3350group8.coursemanager.Business.User;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;

/**
 * Created by Ian Smith on 2016-03-25.
 */
public class CourseIntegrationTest extends AndroidTestCase {
    private Database db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        Log.d("DEBUG", "Attempting to create database");

        db = new SQLDatabase(context);
//        db = new StubDatabase(context);

        db.insertUser(new User("Ian", "car", "1", "smithi35", "umanitoba"));
        CurrentUser.setUser("smithi35");

        // should fail but not crash
        testCourseRetrieval();
        testCourseQuery();

        // actual test
        testCourseInsertion();
        testCourseRetrieval();
        testCourseQuery();

        testGarbageInsertions();
        testUserCourses();
    }

    public void testCourseInsertion() {
        CurrentUser.setUser(db.getUser("smithi35", "car").getEmail());
        Log.d("DEBUG", "Attempting to insert courses");
        Course first = new Course("COMP 1010", "Somewhere", "None", 0);
        Course second = new Course("COMP 1020", "Elsewhere", "None", 3);
        Course third = new Course("COMP 2140", "Basement", "Data Structures and Algorithmsd", 3);
        Course fourth = new Course("COMP 2160", "Upstairs", "Programming Practices", 6);
        Course fifth = new Course("COMP 2280", "Lab", "Outside", 6);

        Log.d("DEBUG", "first insertion" + db.insertCourse(first));
        Log.d("DEBUG", "second insertion" + db.insertCourse(second));
        Log.d("DEBUG", "third insertion" + db.insertCourse(third));
        Log.d("DEBUG", "fourth insertion" + db.insertCourse(fourth));
        Log.d("DEBUG", "fifth insertion" + db.insertCourse(fifth));
    }

    public void testGarbageInsertions() {
        Course badCourse = new Course("", "", "", 0);
        Log.d("DEBUG", "garbage insertion: " + db.insertCourse(badCourse));
    }

    public void testCourseQuery() {
        for (int i = 1; i <= 6; i++) {
            Log.d("DEBUG", "Attempting course query: " + db.getCourse(i));
        }
    }

    public void testUserCourses() {
        ArrayList<Course> courses;
        courses = db.getCourses();

        for (int i = 0; i < courses.size(); i++) {
            Log.d("DEBUG", "course" + i + ": " + courses.get(i));
        }
    }

    public void testCourseRetrieval(){
        Log.d("DEBUG", "Attempting total recall of courses");
        ArrayList<Course> list = db.getAllCourses();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Log.d("DEBUG", "" + list.get(i));
            }
        } else {
            Log.d("DEBUG", "Course list was empty.");
        }
    }

    @Override
    public void tearDown() throws Exception {
        Log.d("DEBUG", "Attempting to close database");
        db.close();
        super.tearDown();
    }
}
