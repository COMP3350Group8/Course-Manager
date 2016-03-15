package comp3350group8.coursemanager.Persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentUser;
import comp3350group8.coursemanager.Business.IntAtom;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Business.User;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Ian Smith on 2016-02-17.
 * needs to implement a database
 */
public class SQLDatabase  extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 12;
    private static final String DATABASE_NAME = "Course Manager";

    public SQLDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_INIT_TABLE = "CREATE TABLE ints ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Value INT)";


        String CREATE_USER_TABLE = "CREATE TABLE Users ( "+
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " UserName TEXT, " +
                " UserPassword TEXT, " +
                " UserNum TEXT UNIQUE, " +
                " UserEmail TEXT UNIQUE, " +
                " UserSchool TEXT);";

        String CREATE_COURSES_TABLE = "CREATE TABLE Courses ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " UserID INTEGER," +
                " CourseName TEXT UNIQUE, " +
                " CourseLocation TEXT, " +
                " CourseDescription TEXT, " +
                " FOREIGN KEY(UserID) References Users(ID));";

        // TODO: Add foreign key reference for course table
        String CREATE_TASK_TABLE = "CREATE TABLE Tasks ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " CourseID INTEGER, " +
                " TaskName TEXT, " +
                " TaskDate TEXT, " +
                " TaskTime TEXT," +
                " FOREIGN KEY(CourseID) References Courses);";

        /* String CREATE_STUDENT_TABLE = "Create TABLE Students ( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "StudentID INTEGER, " +
                "StudentName TEXT, " +
                "StudentEmail TEXT);";
        */

        // coluumns are ID and Value for table ints
        db.execSQL(CREATE_INIT_TABLE);
        db.execSQL(CREATE_COURSES_TABLE);
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_TASK_TABLE);
        // db.execSQL(CREATE_STUDENT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ints");
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
    private static final String[] COURSE_COLUMNS = {"ID", "UserID", "CourseName", "CourseLocation", "CourseDescription"};
    private static final String[] USER_COLUMNS = {"ID", "UserName", "UserPassword", "UserNum",  "UserEmail", "UserSchool"};

    public long insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("DEBUG", USER_COLUMNS[1]);

        ContentValues values = new ContentValues();
        values.put(USER_COLUMNS[2], user.getPassWord());
        values.put(USER_COLUMNS[4], user.getEmail());
        values.put(USER_COLUMNS[3], user.getStudentNum());
        values.put(USER_COLUMNS[1], user.getName());
        values.put(USER_COLUMNS[5], user.getSchool());
        Log.d("DEBUG", values.toString());

        long success = db.insert(TABLE_USERS, null, values);
        db.close();

        return success;
    }

    public long insertCourse(Course course) {
        SQLiteDatabase db = this.getWritableDatabase();
        long success = -1;

        ContentValues values = new ContentValues();

        int userid = getUserID();

        if (userid >= 0) {
            values.put(COURSE_COLUMNS[1], userid);
            values.put(COURSE_COLUMNS[2], course.getName());
            values.put(COURSE_COLUMNS[3], course.getLocation());
            values.put(COURSE_COLUMNS[4], course.getDescription());

            success = db.insert(TABLE_COURSES, null, values);
        }
        db.close();

        return success;
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
                if (cursor.getCount() > 0) {
                    String name = cursor.getString(2);
                    String location = cursor.getString(3);
                    String description = cursor.getString(4);
                    course = new Course(name, location, description);
                }
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
            if(cursor!=null) {
                cursor.moveToFirst();

                if (cursor.getCount() > 0) {
                    String name = cursor.getString(1);
                    String pasword = cursor.getString(2);
                    String studentNum = cursor.getString(3);
                    String school = cursor.getString(4);
                    String emailAdd = cursor.getString(5);
                    user = new User(name, pasword, studentNum, school, emailAdd);
                }

                cursor.close();
            }
        }
        return user;
    }

    private int getUserID() {
        int user = -1;

        if(CurrentUser.getUser() != null) {
            SQLiteDatabase db = this.getReadableDatabase();
            boolean success = false;

            // build query
            //Cursor cursor = db.query(TABLE_USERS, USER_COLUMNS, USER_COLUMNS[4] + " = '" + email + "' AND " + USER_COLUMNS[2] + " = '" + password + "'", new String[]{email, password}, null, null, null, null);
            String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + USER_COLUMNS[4] + "=?";
            String[] args = new String[]{CurrentUser.getUser()};

            Cursor cursor = db.rawQuery(query, args);
            if (cursor != null) {
                cursor.moveToFirst();

                if (cursor.getCount() == 1) {
                    String id = cursor.getString(0);
                    user = Integer.parseInt(id);
                }

                cursor.close();
            }
        }
        return user;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<User>();

        String query = "SELECT * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Course course = null;

        if (cursor.moveToFirst()) {
            do {
                String password = cursor.getString(0);
                String email = cursor.getString(1);
                String number = cursor.getString(2);
                String name = cursor.getString(3);
                String school = cursor.getString(4);

                User u = new User(name, password, number, email, school);

                Log.d("list", u.toString());
                list.add(u);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> list = new ArrayList<Course>();

        String query = "SELECT * FROM " + TABLE_COURSES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Course course = null;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(2);
                String location = cursor.getString(3);
                String description = cursor.getString(4);
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
    public long insertInt(IntAtom item) {
        // get reference to writable db
        SQLiteDatabase db = this.getWritableDatabase();

        // get content values
        ContentValues values = new ContentValues();
        values.put(KEY_VALUE, item.getItem()); // get value

        long success = db.insert(TABLE_INTS, null, values);

        db.close();

        return success;
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
    private static final String[] TASK_COLUMNS = {"ID", "CourseID", "TaskName", "TaskDate", "TaskTime"};

    public long insertTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        long success = -1;
        int courseId = getCourseID();
        Log.d("DEBUG", "CourseID = " + courseId);

        if (courseId >= 0) {
            ContentValues values = new ContentValues();
            values.put(TASK_COLUMNS[1], courseId);
            values.put(TASK_COLUMNS[2], task.getTaskName());
            values.put(TASK_COLUMNS[3], task.getDate());
            values.put(TASK_COLUMNS[4], task.getTime());

            success = db.insert(TABLE_TASKS, null, values);
            db.close();
        }

        return success;
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> list = new ArrayList<Task>();

        String query = "SELECT * FROM " + TABLE_TASKS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        IntAtom atom = null;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(2);
                String date = cursor.getString(3);
                String time = cursor.getString(4);
                Task task = new Task(name, date, time);
                list.add(task);

            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    public int getCourseID() {
        int course = -1;
        Log.d("DEBUG", "current course: " + CurrentCourse.getCourseName());

        // we know the user and an array index
        if(CurrentCourse.getCourseName() != null) {
            SQLiteDatabase db = this.getReadableDatabase();

            String query = "SELECT * FROM " + TABLE_COURSES + " WHERE " + COURSE_COLUMNS[2] + "=?";
            String[] args = new String[]{CurrentCourse.getCourseName()};

            Cursor cursor = db.rawQuery(query, args);
            if (cursor != null) {
                cursor.moveToFirst();

                if (cursor.getCount() == 1) {
                    String id = cursor.getString(0);
                    course = Integer.parseInt(id);
                }

                cursor.close();
            }
        }
        return course;
    }

}
