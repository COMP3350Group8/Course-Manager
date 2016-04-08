package comp3350group8.coursemanager.BusinessTests;

import android.util.Log;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.GPACalculator;

/**
 * Created by Ian Smith on 2016-04-08.
 */
public class TestGPACalculator extends TestCase {
    public void testGradeLess() {
        ArrayList<Course> list = new ArrayList<Course>();

        Course[] array = {new Course("COMP 1010", "", "", "", 3), new Course("COMP 1020", "", "", "", 0), new Course("COMP 2160", "", "", "", 0), new Course("COMP 2140", "", "", "", 6)};

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        GPACalculator.init(list);
        Log.d("DEBUG", "GPA = " +GPACalculator.getGPA());
    }
}
