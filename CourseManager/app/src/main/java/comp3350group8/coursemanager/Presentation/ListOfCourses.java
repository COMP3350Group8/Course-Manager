package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.ListAdapter;

import java.sql.SQLData;
import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentUser;
import comp3350group8.coursemanager.Business.User;
import comp3350group8.coursemanager.Persistence.AppDatabase;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;
import comp3350group8.coursemanager.R;
import comp3350group8.coursemanager.Persistence.staticDB;


/**
 * Created by David on 2016-02-17.
 */
public class ListOfCourses extends Activity {
    private SQLDatabase db = staticDB.getDB();
    private ArrayList<Course> courses;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        CurrentCourse.reset();
        setContentView(R.layout.listofcourses);

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.listView);
        //String[] course= {"COMP 1010", "COMP 1020", "COMP 2130","COMP 2140", "COMP 2150"};

        String user = CurrentUser.getUser();
        User curr = db.getUser(user);
        Log.d("DEBUG", "Current user = " + curr.toString());
        user = curr.toString();
        TextView u = (TextView) findViewById(R.id.UserDescription);
        u.setText(user, TextView.BufferType.NORMAL);

        //TODO: make sure this is getting the information for the right user
        // retrieve contents of "Courses" if any
        courses = db.getCourses();
        Log.d("DEBUG", "size = " + courses.size());
        String[] course = getCourses(courses);
        if (course.length > 0) {
            Log.d("DEBUGG", course[0]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter);

        //SubTable table = staticDB.searchTable("Courses");
        //ArrayList<ListItem> items = table.getAll();
        //lv.setAdapter(new myListAdapter(ListOfCourses.this, items));

        //select a course
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("DEBUG", "Selected course with id: " + id);
                if (id < Integer.MAX_VALUE && id > Integer.MIN_VALUE) {
                    int index = (int)id;
                    Course curr = courses.get(index);
                    Log.d("DEBUG", "Current course = " + id+1);
                    CurrentCourse.setCourse(curr.getName());
                    CurrentCourse.setID(id+1);

                    Log.d("DEBUG", "course = " + CurrentCourse.getCourseName());
                }
                Object o = lv.getItemAtPosition(position);

                startActivity(new Intent(ListOfCourses.this, TaskList.class));
               // Toast.makeText(ListOfCourses.this, o.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    protected void onResume() {
        super.onResume();
        CurrentCourse.reset();
    }

    //TODO: do this somewhere else
    public String[] getCourses(ArrayList<Course> list) {
        String[] out = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            out[i] = list.get(i).getName();
        }

        return out;
    }

    public void AddNewCourse (View v) {
        startActivity(new Intent(ListOfCourses.this, AddCourse.class));
    }
}
