package comp3350group8.coursemanager.Persistence;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.IntAtom;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Business.User;

/**
 * Created by Ian Smith on 2016-03-02.
 */
public interface Database {
    long insertInt(IntAtom item);
    IntAtom getInt(int id, IntAtom atom);
    ArrayList<IntAtom> getAllInts();

    long insertUser(User user);
    User getUser(String email, String password);
    User getUser(String email);
    ArrayList<User> getAllUsers();

    long insertCourse(Course course);
    Course getCourse(int id);
    ArrayList<Course> getCourses();
    ArrayList<Course> getAllCourses();

    long insertTask(Task task);
    ArrayList<Task> getTasks();
    ArrayList<Task> getAllTasks();
    Task getTask(int id);
    boolean updateTask(Task task);

    void close();
}
