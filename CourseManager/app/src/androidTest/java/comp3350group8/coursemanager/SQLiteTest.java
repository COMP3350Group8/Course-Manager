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
        
        testIntInsertion();
        testIntRetrieval();
        testIntQuery();

        // should fail but not crash
        testCourseRetrieval();
        testCourseQuery();

        // actual test
        testCourseInsertion();
        testCourseRetrieval();
        testCourseQuery();
    }

    //@Test
    public void testIntInsertion() {
        for (int i = 0; i < 10; i++) {
            IntAtom c = new IntAtom(i);
            Log.d("DEBUG", "Attempting to insert " + i);
            db.insertInt(c);
        }
    }

    public void testIntRetrieval() {
        Log.d("DEBUG", "Attempting total recall");
        ArrayList<IntAtom> list = db.getAllInts();

        for (int i = 0; i < list.size(); i++) {
            Log.d("DEBUG", "" + list.get(i));
        }
    }

    public void testIntQuery() {
        Log.d("DEBUG", "Attempted query: " + db.getInt(1));
    }

    public void testCourseInsertion() {
        Log.d("DEBUG", "Attempting to insert courses");
        Course first = new Course("COMP 1010", "Somewhere", "None");
        Course second = new Course("COMP 1020", "Elsewhere", "None");
        Course third = new Course("COMP 2140", "Basement", "Data Structures and Algorithmsd");
        Course fourth = new Course("COMP 2160", "Upstairs", "Programming Practices");
        Course fifth = new Course("COMP 2280", "Lab", "Outside");

        db.insertCourse(first);
        db.insertCourse(second);
        db.insertCourse(third);
        db.insertCourse(fourth);
        db.insertCourse(fifth);
    }

    public void testCourseQuery() {
        Log.d("DEBUG", "Attempting query: " + db.getCourse(1));
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
