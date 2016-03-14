package comp3350group8.coursemanager.Persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.IntAtom;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Business.User;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Ian Smith on 2016-02-17.
 * needs to implement a database
 */
public class SQLDatabase  extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Course Manager";

    public SQLDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_INIT_TABLE = "CREATE TABLE ints ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Value INT)";

        String CREATE_COURSES_TABLE = "CREATE TABLE Courses ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " CourseName TEXT, " +
                " CourseLocation TEXT, " +
                " CourseDescription TEXT)";

        String CREATE_USER_TABLE = "CREATE TABLE Users ( "+
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " UserName TEXT, " +
                " UserPassword TEXT, " +
                " UserNum TEXT, " +
                " UserEmail TEXT, " +
                " UserSchool TEXT)";

        String CREATE_TASK_TABLE = "CREATE TABLE Tasks ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " TaskName TEXT, " +
                " TaskDate TEXT, " +
                " TaskTime TEXT,)";

        /* String CREATE_STUDENT_TABLE = "Create TABLE Students ( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "StudentID INTEGER, " +
                "StudentName TEXT, " +
                "StudentEmail TEXT)";
        */

        // coluumns are ID and Value for table ints
        db.execSQL(CREATE_INIT_TABLE);
        db.execSQL(CREATE_COURSES_TABLE);
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_TASK_TABLE);
        // db.execSQL(CREATE_STUDENT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Init");
        db.execSQL("DROP TABLE IF EXISTS Courses");
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS Tasks");
        DATABASE_VERSION = newVersion;

        this.onCreate(db);
    }

    //private static final String TABLE_STUDENTS = "Students";
    //private static final String[] STUDENT_COLUMNS = {"ID", "StudentID", "StudentName", "StudentEmail"};

    private static final String TABLE_COURSES = "Courses";
    private static final String TABLE_USERS = "Users";
    private static final String[] COURSE_COLUMNS = {"ID", "CourseName", "CourseLocation", "CourseDescription"};
    private static final String[] USER_COLUMNS = {"ID", "UserName", "UserPassword", "UserNum",  "UserEmail", "UserSchool"};

    public void insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("DEBUG", USER_COLUMNS[1]);

        ContentValues values = new ContentValues();
        values.put(USER_COLUMNS[1], user.getName());
        values.put(USER_COLUMNS[2], user.getPassWord());
        values.put(USER_COLUMNS[3], user.getStudentNum());
        values.put(USER_COLUMNS[4], user.getEmail());
        values.put(USER_COLUMNS[5], user.getSchool());
        Log.d("DEBUG", values.toString());

        db.insert(TABLE_USERS, null, values);
        db.close();

    }


    public void insertCourse(Course course) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COURSE_COLUMNS[1], course.getName());
        values.put(COURSE_COLUMNS[2], course.getLocation());
        values.put(COURSE_COLUMNS[3], course.getDescription());

        db.insert(TABLE_COURSES, null, values);
        db.close();
    }

    public Course getCourse(int id) {
        Course course = null;

        if (id > 0) {
            SQLiteDatabase db = this.getReadableDatabase();

            // build query
            Cursor cursor =
                    db.query(TABLE_COURSES, COURSE_COLUMNS, " id = ?", new String[]{String.valueOf(id)}, null, null, null, null);

            boolean successful = cursor.moveToFirst();
            Log.d("GetInt", "" + successful);

            if (successful) {
                String name = cursor.getString(0);
                String location = cursor.getString(1);
                String description = cursor.getString(2);
                course = new Course(name, location, description);
            }
            cursor.close();
        }

        return course;
    }

    public User getUser(String email, String password)
    {
        User user = null;

        if(email!=null && password!=null)
        {
            SQLiteDatabase db = this.getReadableDatabase();
            boolean success = false;

            // build query
            //Cursor cursor = db.query(TABLE_USERS, USER_COLUMNS, USER_COLUMNS[4] + " = '" + email + "' AND " + USER_COLUMNS[2] + " = '" + password + "'", new String[]{email, password}, null, null, null, null);
            String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + USER_COLUMNS[4] + "=? AND " + USER_COLUMNS[2] + "=?";
            String[] args = new String[] {email, password};
            Cursor cursor = db.rawQuery(query, args);
            if(cursor!=null)
            {
                cursor.moveToFirst();
                success = true;

            }

            if(success)
            {
                String name = cursor.getString(1);
                String pasword = cursor.getString(2);
                String studentNum = cursor.getString(3);
                String school= cursor.getString(4);
                String emailAdd = cursor.getString(5);
                user = new User(name, pasword, studentNum, school, emailAdd);

            }
            cursor.close();

        }
        return user;
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> list = new ArrayList<Course>();

        String query = "SELECT * FROM " + TABLE_COURSES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Course course = null;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(0);
                String location = cursor.getString(1);
                String description = cursor.getString(2);
                course = new Course(name, location, description);
                Log.d("list", course.toString());
                list.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    private static final String TABLE_INTS = "ints";
    // ints table columns
    private static final String KEY_ID = "ID";
    private static final String KEY_VALUE = "Value";
    private static final String[] COLUMNS = {KEY_ID, KEY_VALUE};

    // CRUD methods

    // insert parameter into the database
    public void insertInt(IntAtom item) {
        // get reference to writable db
        SQLiteDatabase db = this.getWritableDatabase();

        // get content values
        ContentValues values = new ContentValues();
        values.put(KEY_VALUE, item.getItem()); // get value

        db.insert(TABLE_INTS, null, values);

        db.close();
    }

    public IntAtom getInt(int id) {
        IntAtom atom = null;

        if (id > 0) {
            SQLiteDatabase db = this.getReadableDatabase();

            // build query
            Cursor cursor =
                    db.query(TABLE_INTS, COLUMNS, " id = ?", new String[]{String.valueOf(id)}, null, null, null, null);

            boolean successful = cursor.moveToFirst();
            Log.d("GetInt", "" + successful);

            if (successful) {
                atom = new IntAtom(Integer.parseInt(cursor.getString(0)));
            }
            cursor.close();
        }

        return atom;
    }

    public ArrayList<IntAtom> getAllInts() {
        ArrayList<IntAtom> list = new ArrayList<IntAtom>();

        String query = "SELECT * FROM " + TABLE_INTS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        IntAtom atom = null;

        if (cursor.moveToFirst()) {
            do {
                atom = new IntAtom(Integer.parseInt(cursor.getString(1)));
                Log.d("list", atom.toString());
                list.add(atom);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    //Adding Tasks
    private static final String TABLE_TASKS = "Tasks";
    private static final String[] TASK_COLUMNS = {"TaskName", "TaskDueDate", "TaskDueTime"};

    public void insertTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TASK_COLUMNS[1], task.getTaskName());
        values.put(TASK_COLUMNS[2], task.getDate());
        values.put(TASK_COLUMNS[3], task.getTime());

        db.insert(TABLE_TASKS, null, values);
        db.close();
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> list = new ArrayList<Task>();

        String query = "SELECT * FROM " + TABLE_TASKS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        IntAtom atom = null;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(0);
                String date = cursor.getString(1);
                String time = cursor.getString(2);
                Task task = new Task(name, date, time);
                list.add(task);

            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

}
