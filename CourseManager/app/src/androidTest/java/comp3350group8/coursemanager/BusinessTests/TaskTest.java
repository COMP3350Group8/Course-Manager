package comp3350group8.coursemanager.BusinessTests;

import android.util.Log;

import junit.framework.TestCase;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.Task;

/**
 * Created by Ian Smith on 2016-03-14.
 */
public class TaskTest extends TestCase {
    public void testTask() {
        Task[] tasks = {new Task("Do it", "September 1, 2016", "12:00am", 0.1), new Task("Assignment", "September 2, 2016", "12:00am", 0.2), new Task("It do", "", "", 0.3), new Task("", "", "", -1)};

        assertFalse(tasks[3].equals(tasks[2]));
        assertTrue(tasks[2].equals(tasks[2]));
        assertFalse(tasks[2].equals(new Course("Name", "Location", "Description", 0)));
        assertNotNull(tasks[1].getDate());
        assertNotNull(tasks[0].getName());
        assertNotNull(tasks[0].getTime());
        assertTrue(tasks[0].getWeight() <= 1);
        assertFalse(tasks[1].getWeight() > 1);


        tasks[0].setScore(0.5); // 50%
        tasks[1].setScore(1.0);
        tasks[2].setScore(0.85);
        assertEquals(tasks[1].getScore(), 1.0);

        Log.d("DEBUG", "" + tasks[0].getActualScore());
        assertEquals(0.05, tasks[0].getActualScore());

        Log.d("DEBUG", "" + tasks[2].getActualScore());
        assertEquals(0.255, tasks[2].getActualScore());

        for (int i = 0; i < tasks.length; i++) {
            Log.d("DEBUG", tasks[i].toString());
        }
    }
}
