package comp3350group8.coursemanager.DatabaseTests;

import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;
import android.util.Log;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentUser;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Business.User;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;

/**
 * Created by Ian Smith on 2016-03-25.
 */
public class TaskIntegrationTest extends AndroidTestCase {
    private SQLDatabase db;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
        Log.d("DEBUG", "Attempting to create database");
        db = new SQLDatabase(context);
//        db = new StubDatabase(context);

        User first = new User("Ian", "car", "1", "smithi35", "umanitoba");
        db.insertUser(first);
        CurrentUser.setUser(first.getEmail());

        Course c = new Course("COMP 1010", "Somewhere", "None");
        db.insertCourse(c);
        ArrayList<Course> courses = db.getCourses();
        CurrentCourse.setCourse(courses.get(0).getName());
        CurrentCourse.setID(courses.get(0).getID());

        testTaskRetrieval();
        testTaskQuery();

        testTaskInsertion();
        testTaskRetrieval();
        testTaskQuery();
        testTaskUpdate();
        testTaskRetrieval();
    }

    public void testTaskInsertion() {
        Task[] tasks = {new Task("Do it", "September 1, 2016", "12:00am", 1), new Task("Assignment", "September 2, 2016", "12:00am", 0.5), new Task("It do", "", "", 0.5), new Task("", "", "", 0)};
        /*Course c = db.getCourse(1);
        CurrentCourse.setCourse(c.getName());
        CurrentCourse.setID((long)c.getID());*/

        for (int i = 0; i < tasks.length; i++) {
            long insertion = db.insertTask(tasks[i]);
            Log.d("DEBUG", "task insertion = " + insertion);
        }
    }

    public void testTaskRetrieval() {
        Log.d("DEBUG", "Attempting total recall of tasks");
        ArrayList<Task> list = db.getTasks();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Log.d("DEBUG", "" + list.get(i));
            }
        } else {
            Log.d("DEBUG", "task list was empty.");
        }
    }

    public void testTaskQuery() {
        Log.d("DEBUG", "Attempting task query: " + db.getTask(2));
    }

    public void testTaskUpdate() {
        Task newTask = db.getTask(2);
        Log.d("DEBUG", "Attempting task query: " + db.getTask(2));

        newTask.setScore(0.5);
        db.updateTask(newTask);

        Task query = db.getTask(2);
        Log.d("DEBUG", "Retrieving updated task: " + query.toString());
        Log.d("DEBUG", "Actual score of query = " + query.getActualScore());
    }
}
