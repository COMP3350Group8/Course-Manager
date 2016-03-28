package comp3350group8.coursemanager.BusinessTests;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.ArrayConverter;
import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.Task;

/**
 * Created by Ian Smith on 2016-03-28.
 */
public class ArrayConverterTest extends TestCase {
    public void testArrayConverterCourse() {
        Course[] array = {new Course("COMP 1010", "", ""), new Course("COMP 1020", "", ""), new Course("COMP 2140", "", ""), new Course("COMP 2150", "", ""), new Course("COMP 2160", "", "")};
        ArrayList<Course> courses = new ArrayList<Course>();

        for (int i = 0; i < array.length; i++) {
            courses.add(array[i]);
        }

        String[] out = ArrayConverter.convertCourses(courses);
        for (int i = 0; i < array.length; i++) {
            assertTrue(array[i].getName().equals(out[i]));
        }
    }

    public void testArrayConverterTasks() {
        Task[] array = {new Task("Ass1", "", "", 0.1), new Task("Ass2", "", "", 0.2), new Task("Ass3", "", "", 0.3), new Task("Ass4", "", "", 0.4)};
        ArrayList<Task> tasks = new ArrayList<Task>();

        for (int i = 0; i < array.length; i++) {
            tasks.add(array[i]);
        }

        String[] out = ArrayConverter.convertTasks(tasks);
        for (int i = 0; i < array.length; i++) {
            assertTrue(array[i].getName().equals(out[i]));
        }
    }
}
