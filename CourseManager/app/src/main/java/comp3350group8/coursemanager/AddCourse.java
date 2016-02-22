package comp3350group8.coursemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.R;

/**
 * Created by David on 2016-02-17.
 */
public class AddCourse extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);


    }
    //final Intent newActivity = new Intent(AddCourse.this, ListOfCourses.class);
    public void buttonOnClick (View v)
    {
        String []data = new String[3];
        EditText courseName = (EditText) findViewById(R.id.courseName);
        EditText courseloc = (EditText) findViewById(R.id.location);
        EditText coursedescr = (EditText) findViewById(R.id.description);

        Course newCourse = new Course(courseName.getText().toString(), courseloc.getText().toString(), coursedescr.getText().toString());
        staticDB.insert(newCourse, "Courses");
        //newActivity.putExtra("name", courseName.toString());
        //newActivity.putExtra("location", courseloc.toString());
        //newActivity.putExtra("description", coursedescr.toString());
        data[0]= courseName.getText().toString();
        data[1] = courseloc.getText().toString();
        data[2] = coursedescr.getText().toString();


        //startActivity(newActivity);
        startActivity(new Intent(AddCourse.this, ListOfCourses.class));

    }
}
