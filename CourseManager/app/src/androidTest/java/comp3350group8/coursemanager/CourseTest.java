package comp3350group8.coursemanager;
import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.IntAtom;

import android.util.Log;

import junit.framework.TestCase;

/**
 * Created by Ian Smith on 2016-03-13.
 */
public class CourseTest extends TestCase {
    public void testCourse() {
        Course[] courses = {new Course("COMP 1010", "elsewhere", "Intro"), new Course("COMP 1020", "basement", "Outro"), new Course("COMP 2140", "downstairs", "Data Structures")};

        for (int i = 0; i < courses.length; i++ ) {
            Log.d("DEBUG", courses[i].toString());
        }

        assertNotNull(courses[0].getName());
        assertNotNull(courses[1].getDescription());
        assertNotNull(courses[2].getLocation());
        assertFalse(courses[1].equals(courses[2]));
        assertNotNull(courses[2].toString());
        assertFalse(courses[2].equals(courses[1]));
        assertTrue(courses[1].equals(courses[1]));
        assertFalse(courses[2].equals(new IntAtom(3)));
    }
}
