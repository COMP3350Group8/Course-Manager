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
        Task[] tasks = {new Task("Do it", "September 1, 2016", "12:00am"), new Task("Assignment", "September 2, 2016", "12:00am"), new Task("It do", "", "")};

        assertTrue(tasks[2].equals(tasks[2]));
        assertFalse(tasks[2].equals(new Course("Name", "Location", "Description")));
        assertNotNull(tasks[1].getDate());
        assertNotNull(tasks[0].getTaskName());
        assertNotNull(tasks[0].getTime());

        for (int i = 0; i < tasks.length; i++) {
            Log.d("DEBUG", tasks[i].toString());
        }
    }
}
