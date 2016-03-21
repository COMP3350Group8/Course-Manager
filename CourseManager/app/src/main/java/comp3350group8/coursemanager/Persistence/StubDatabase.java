package comp3350group8.coursemanager.Persistence;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.ListItem;
import comp3350group8.coursemanager.Business.SubTable;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Business.User;

/**
 * Created by Ian Smith on 2016-02-12.
 */
public class StubDatabase extends SQLDatabase {
    private static ArrayList<SubTable> db;

    public StubDatabase(Context context) {
        super(context);
        db = new ArrayList<SubTable>();
        db.add(new SubTable("Courses"));
        db.add(new SubTable("Users"));
        db.add(new SubTable("Tasks"));
        Log.d("Constructor", "Called");

        insertCourse(new Course("COMP 1010", "E2-105","None"));
        insertTask(new Task("None", "01/27/93", "12:00am", 100));
        insertUser(new User("Guest", " ", "0", "", ""));
    }

    //@Override
    //public void onCreate(SQLiteDatabase data) {
        //db = new ArrayList<SubTable>();
        //db.add(new SubTable("Courses"));
    //}

    // returns the SubTable associated with name
    private SubTable retrieveTable(String name) {
        SubTable out = null;

        for (int i = 0; i < db.size() && out == null; i++) {
            if (db.get(i).getName().equals(name)) {
                out = db.get(i);
            }
        }

        return out;
    }

    // inserts a Course into the Courses SubTable
    public long insertCourse(Course course) {
        Log.d("DEBUG", "Inserting " + course.toString());
        SubTable table = retrieveTable("Courses");
        int size = table.size();
        table.insert(course);
        Log.d("DEBUG", "table: " + table.toString());

        long success = -1;

        if (table.size() > size) {
            success = 1;
        }

        return success;
    }

    // returns the course located in Courses at index id
    public Course getCourse(int id) {
        Course course = null;

        if (id > 0) {
            SubTable table = retrieveTable("Courses");

            if (id < table.size()) {
                course = (Course)table.get(id);
            }
        }

        return course;
    }

    // returns an arraylist of all the courses in the SubTable
    public ArrayList<Course> getAllCourses() {
        ArrayList<ListItem> list = retrieveTable("Courses").getAll();

        ArrayList<Course> out = new ArrayList<Course>();
        Log.d("SIZE", "getallCourses: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Course) {
                Course course = (Course) list.get(i);
                out.add(course);
            }
        }

        return out;
    }

    public long insertUser(User user){
        SubTable table = retrieveTable("Users");
        int size = table.size();
        table.insert(user);

        long success = -1;

        if (table.size() > size) {
            success = 1;
        }

        return success;
    }

    public long insertTask(Task task) {
        SubTable table = retrieveTable("Tasks");
        int size = table.size();
        table.insert(task);

        long success = -1;

        if (table.size() > size) {
            success = 1;
        }

        return success;
    }

    public ArrayList<Task> getTasks() {
        ArrayList<ListItem> tasks = new ArrayList<ListItem>();
        SubTable table = retrieveTable("Tasks");
        tasks = table.getAll();

        ArrayList<Task> list = new ArrayList<Task>();
        for (int i = 0; i < tasks.size(); i++) {
            list.add((Task)tasks.get(i));
        }

        return list;
    }
}
