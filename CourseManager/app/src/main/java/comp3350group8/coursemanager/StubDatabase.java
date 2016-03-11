package comp3350group8.coursemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import comp3350group8.coursemanager.AppDatabase;
import comp3350group8.coursemanager.ListItem;

/**
 * Created by Ian Smith on 2016-02-12.
 */

import java.util.ArrayList;

/**
 * Created by David on 2016-02-22.
 */
public class StubDatabase extends SQLDatabase {
    private static ArrayList<SubTable> db;

    public StubDatabase(Context context) {
        super(context);
        db = new ArrayList<SubTable>();
        db.add(new SubTable("Courses"));
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
    public void insertCourse(Course course) {
        SubTable table = retrieveTable("Courses");
        table.insert(course);
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

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Course) {
                Course course = (Course) list.get(i);
                out.add(course);
            }
        }

        return out;
    }

}
