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
import comp3350group8.coursemanager.Business.LetterGrade;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Business.User;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Ian Smith on 2016-02-17.
 * needs to implement a database
 */
public class SQLDatabase  extends SQLiteOpenHelper implements Database{
<<<<<<< HEAD
    private static int DATABASE_VERSION = 23;
=======
    private static int DATABASE_VERSION = 27;
>>>>>>> Develop
    private static final String DATABASE_NAME = "Course Manager";

    public SQLDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /*String CREATE_INIT_TABLE = "CREATE TABLE ints ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " Value INT)";*/
        String CREATE_INIT_TABLE = IntAtom.getTableSQL();

        String CREATE_USER_TABLE = "CREATE TABLE Users ( "+
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                " UserName TEXT, " +
                " UserPassword TEXT, " +
                " UserNum TEXT UNIQUE NOT NULL, " +
                " UserEmail TEXT UNIQUE NOT NULL, " +
                " UserSchool TEXT);";

        String CREATE_COURSES_TABLE = "CREATE TABLE Courses ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " UserID INTEGER," +
                " CourseName TEXT UNIQUE NOT NULL, " +
                " CourseLocation TEXT, " +
                " CourseDescription TEXT, " +
<<<<<<< HEAD
                " CourseGrade TEXT, " +
                " CourseCreditHours INTEGER, " +
=======
                " CourseDate TEXT," +
>>>>>>> Develop
                " FOREIGN KEY(UserID) References Users(ID));";

        String CREATE_TASK_TABLE = "CREATE TABLE Tasks ( " +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " UserID INTEGER, " +
                " CourseID INTEGER, " +
                " TaskName TEXT UNIQUE NOT NULL, " +
                " TaskDate TEXT, " +
                " TaskTime TEXT," +
                " TaskWeight FLOAT, " +
                " TaskScore FLOAT, " +
                " FOREIGN KEY(UserID) References Users, " +
                " FOREIGN KEY(CourseID) References Courses);";

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

//    private static final String TABLE_INTS = "ints";
//    private static final String[] INTS_COLUMNS = {"ID", "Value"};

    public long insertInt(IntAtom item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = item.getValues();

        long success = db.insert(IntAtom.getTableName(), null, values);
        db.close();

        return success;
    }

    public IntAtom getInt(int id, IntAtom atom) {
        if (id > 0) {
            SQLiteDatabase db = this.getReadableDatabase();

            // build query
            Cursor cursor =
                    db.query(IntAtom.getTableName(), IntAtom.getColumns(), " ID = ?", new String[]{String.valueOf(id)}, null, null, null, null);

            boolean successful = cursor.moveToFirst();
            Log.d("GetInt", "" + successful);

            if (successful) {
                atom.setItem(Integer.parseInt(cursor.getString(0)));
            }
            cursor.close();
        }

        return atom;
    }

    public ArrayList<IntAtom> getAllInts() {
        ArrayList<IntAtom> list = new ArrayList<IntAtom>();

        String query = "SELECT * FROM " + IntAtom.getTableName();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        IntAtom atom = null;

        if (cursor.moveToFirst()) {
            do {
                atom = new IntAtom(Integer.parseInt(cursor.getString(1)));
                Log.d("list", atom.toString());
                atom.setID(Integer.parseInt(cursor.getString(0)));
                list.add(atom);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    private static final String TABLE_USERS = "Users";
    private static final String[] USER_COLUMNS = {"ID", "UserName", "UserPassword", "UserNum",  "UserEmail", "UserSchool"};

    public long insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("DEBUG", USER_COLUMNS[1]);

        ContentValues values = new ContentValues();
        values.put(USER_COLUMNS[1], user.getName());
        values.put(USER_COLUMNS[2], user.getPassWord());
        values.put(USER_COLUMNS[3], user.getStudentNum());
        values.put(USER_COLUMNS[4], user.getEmail());
        values.put(USER_COLUMNS[5], user.getSchool());
        Log.d("DEBUG", values.toString());

        long success = db.insert(TABLE_USERS, null, values);
        db.close();

        return success;
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
                    user.setID(Integer.parseInt(cursor.getString(0)));
                }

                cursor.close();
            }
        }
        return user;
    }

    public User getUser(String email) {
        User user = null;

        if(email != null)
        {
            SQLiteDatabase db = this.getReadableDatabase();
            boolean success = false;

            // build query
            //Cursor cursor = db.query(TABLE_USERS, USER_COLUMNS, USER_COLUMNS[4] + " = '" + email + "' AND " + USER_COLUMNS[2] + " = '" + password + "'", new String[]{email, password}, null, null, null, null);
            String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + USER_COLUMNS[4] + "=?";
            String[] args = new String[] {email};

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

                    Log.d("getUser", "user = " + user.toString());
                    user.setID(Integer.parseInt(cursor.getString(0)));
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

            // the user's email address, like their ID, is unique
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
                Log.d("DEBUG", "User = " + password + ", " + email + ", " + number + ", " + name + ", " + school);

                Log.d("list", u.toString());
                list.add(u);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    private static final String TABLE_COURSES = "Courses";
<<<<<<< HEAD
    private static final String[] COURSE_COLUMNS = {"ID", "UserID", "CourseName", "CourseLocation", "CourseDescription", "CourseGrade", "CourseCreditHours"};
=======
    private static final String[] COURSE_COLUMNS = {"ID", "UserID", "CourseName", "CourseLocation", "CourseDescription", "CourseDate"};
>>>>>>> Develop

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
<<<<<<< HEAD
            values.put(COURSE_COLUMNS[5], course.getGrade().getGrade());
            values.put(COURSE_COLUMNS[6], course.getCreditHours());
=======
            values.put(COURSE_COLUMNS[5], course.getDate());
>>>>>>> Develop

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
<<<<<<< HEAD
                    int credit = Integer.parseInt(cursor.getString(6));
                    course = new Course(name, location, description, credit);

                    LetterGrade g = new LetterGrade(cursor.getString(5));
                    course.setGrade(g);
=======
                    String date = cursor.getString(5);
                    course = new Course(name, location, description, date);
>>>>>>> Develop
                    course.setID(Integer.parseInt(cursor.getString(0)));
                }
            }
            cursor.close();
        }

        return course;
    }

    public ArrayList<Course> getCourses() {
        ArrayList<Course> list = new ArrayList<Course>();
        String user = CurrentUser.getUser();
        User u = getUser(user);
        Log.d("DEBUG", "Current user = " + u.toString());

        String query = "SELECT * FROM " + TABLE_COURSES + " WHERE " + COURSE_COLUMNS[1] + "=? ORDER BY " + COURSE_COLUMNS[2] + " ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[] {"" + u.getID()});

        Course course = null;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(2);
                String location = cursor.getString(3);
                String description = cursor.getString(4);
<<<<<<< HEAD
                int credit = Integer.parseInt(cursor.getString(6));
                course = new Course(name, location, description, credit);

                LetterGrade g = new LetterGrade(cursor.getString(5));
                course.setGrade(g);
=======
                String date = cursor.getString(5);
                course = new Course(name, location, description, date);
                Log.d("list", course.toString());
>>>>>>> Develop
                course.setID(Integer.parseInt(cursor.getString(0)));
                list.add(course);
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
<<<<<<< HEAD
                int credit = Integer.parseInt(cursor.getString(6));
                course = new Course(name, location, description, credit);

                LetterGrade g = new LetterGrade(cursor.getString(5));
                course.setGrade(g);
=======
                String date = cursor.getString(5);

                course = new Course(name, location, description, date);
>>>>>>> Develop
                course.setID(Integer.parseInt(cursor.getString(0)));

                list.add(course);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    private static final String TABLE_TASKS = "Tasks";
    private static final String[] TASK_COLUMNS = {"ID", "UserID", "CourseID", "TaskName", "TaskDate", "TaskTime", "TaskWeight", "TaskScore"};

    public long insertTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        long success = -1;
        int courseId = getCourseID();
        int userId = getUserID();
        Log.d("DEBUG", "CourseID = " + courseId);
        Log.d("DEBUG", "task = " + task.toString());

        if (courseId >= 0) {
            ContentValues values = new ContentValues();
            values.put(TASK_COLUMNS[1], userId);
            values.put(TASK_COLUMNS[2], courseId);
            values.put(TASK_COLUMNS[3], task.getName());
            values.put(TASK_COLUMNS[4], task.getDate());
            values.put(TASK_COLUMNS[5], task.getTime());
            values.put(TASK_COLUMNS[6], task.getWeight());

            success = db.insert(TABLE_TASKS, null, values);
            db.close();
        }

        return success;
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> list = new ArrayList<Task>();

        String query = "SELECT * FROM " + TABLE_TASKS + " WHERE " + TASK_COLUMNS[1] + "=?" + " AND " + TASK_COLUMNS[2]+ "=? ORDER BY " + TASK_COLUMNS[3] + " ASC";
        Log.d("DEBUG", "Task query = " + query);
//        Log.d("DEBUG", "Task parameter = " + CurrentCourse.getID());
        SQLiteDatabase db = this.getReadableDatabase();

        int cid = getCourseID();
        int uid = getUserID();
        Cursor cursor = db.rawQuery(query, new String[] {"" + uid, "" + cid});

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                // exclude foreign userID, courseID
                String name = cursor.getString(3);
                String date = cursor.getString(4);
                String time = cursor.getString(5);
                String weight = cursor.getString(6);
                double w = 0.0;

                if (weight != null) {
                    w = Double.parseDouble(weight);
                }
                Task task = new Task(name, date, time, w);
                task.setID(Integer.parseInt(id));

                String score = cursor.getString(7);
                double s = 0;
                if (score != null) {
                    s = Double.parseDouble(score);
                }
                task.setScore(s);
                list.add(task);

            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> list = new ArrayList<Task>();

        String query = "SELECT * FROM " + TABLE_TASKS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                // exclude foreign courseID
                String name = cursor.getString(3);
                String date = cursor.getString(4);
                String time = cursor.getString(5);
                String weight = cursor.getString(6);
                double w = 0.0;

                if (weight != null) {
                    w = Double.parseDouble(weight);
                }
                Task task = new Task(name, date, time, w);
                task.setID(Integer.parseInt(id));

                String score = cursor.getString(7);
                double s = 0;
                if (score != null) {
                    s = Double.parseDouble(score);
                    task.setScore(s);
                }
                list.add(task);

            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    public Task getTask(int id) {
        Task t = null;

        String query = "SELECT * FROM " + TABLE_TASKS + " WHERE ID = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[] {"" + id});

        if (cursor.moveToFirst()) {
            //"ID", "CourseID", "TaskName", "TaskDate", "TaskTime", "TaskWeight", "TaskScore", "TaskActualScore"
            String iD = cursor.getString(0);
            // exclude foreign courseID
            String name = cursor.getString(3);
            String date = cursor.getString(4);
            String time = cursor.getString(5);
            String weight = cursor.getString(6);

            t = new Task(name, date, time, Double.parseDouble(weight));
            t.setID(Integer.parseInt(iD));

            String score = cursor.getString(7);
            Log.d("DEBUG", "task = " + t.toString());

            if (score != null) {
                t.setScore(Double.parseDouble(score));
            }

        }
        cursor.close();

        return t;
    }

    public boolean updateTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(TASK_COLUMNS[0], task.getID());
        args.put(TASK_COLUMNS[3], task.getName());
        args.put(TASK_COLUMNS[4], task.getDate());
        args.put(TASK_COLUMNS[5], task.getTime());
        args.put(TASK_COLUMNS[6], task.getWeight());
        args.put(TASK_COLUMNS[7], task.getScore());

        return db.update(TABLE_TASKS, args, "ID = " + task.getID(), null) > 0;
    }

    private int getCourseID() {
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
