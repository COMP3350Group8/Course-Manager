package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.ArrayConverter;
import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentUser;
import comp3350group8.coursemanager.Business.GPACalculator;
import comp3350group8.coursemanager.Business.User;
import comp3350group8.coursemanager.Business.myListAdapter;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.R;
import comp3350group8.coursemanager.Persistence.staticDB;


/**
 * Created by David on 2016-02-17.
 */
public class ListOfCourses extends Activity {
    private Database db;
    private ArrayList<Course> courses;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        CurrentCourse.reset();
        setContentView(R.layout.listofcourses);
        db = staticDB.getDB();

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.listView);
        //String[] course= {"COMP 1010", "COMP 1020", "COMP 2130","COMP 2140", "COMP 2150"};

        String user = CurrentUser.getUser();
        User curr = db.getUser(user);
        courses = db.getCourses();
        GPACalculator.init(courses);
        double gpa = GPACalculator.getGPA();
        curr.setGPA(gpa);
        Log.d("DEBUG", "Current user = " + curr.toString());
        user = curr.toString();

        TextView u = (TextView) findViewById(R.id.UserDescription);
        u.setText(user, TextView.BufferType.NORMAL);

        Log.d("DEBUG", "size = " + courses.size());
        if (courses.size() > 0) {
            Log.d("DEBUG", "First course = " + courses.get(0));
        }

        Log.d("DEBUG", "GPA = " + gpa);
        String[] course = ArrayConverter.convertCourses(courses);

        if (course.length > 0) {
            Log.d("DEBUGG", course[0]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter);

//        lv.setAdapter(new myListAdapter(ListOfCourses.this, courses));

        //select a course
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("DEBUG", "Selected course with id: " + id);

                if (id < Integer.MAX_VALUE && id > Integer.MIN_VALUE) {
                    int index = (int)id;
                    Course curr = courses.get(index);
                    Log.d("DEBUG", "Current course = " + curr.getID());

                    CurrentCourse.setCourse(curr.getName());
                    CurrentCourse.setID(curr.getID());

                    Log.d("DEBUG", "course = " + CurrentCourse.getCourseName() + ", " + CurrentCourse.getID());
                }
                //Object o = lv.getItemAtPosition(position);

                startActivity(new Intent(ListOfCourses.this, TaskList.class));
               // Toast.makeText(ListOfCourses.this, o.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    protected void onResume() {
        super.onResume();
        CurrentCourse.reset();
    }

    public void AddNewCourse (View v) {
        startActivity(new Intent(ListOfCourses.this, AddCourse.class));
    }

    public void logout(View v) {
        startActivity(new Intent(ListOfCourses.this, LoginActivity.class));
        finish();
    }
}
