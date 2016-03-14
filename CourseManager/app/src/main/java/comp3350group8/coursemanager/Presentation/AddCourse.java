package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.Presentation.ListOfCourses;
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
        // String []data = new String[3];

        // retrieve the data supplied to the form
        EditText courseName = (EditText) findViewById(R.id.courseName);
        if(courseName.length() ==  0) {
            courseName.setError("Enter course");
        }
        else {
            EditText courseloc = (EditText) findViewById(R.id.location);

            EditText coursedescr = (EditText) findViewById(R.id.description);

            // create instance of Course and send to the database
            Course newCourse = new Course(courseName.getText().toString(),
                    courseloc.getText().toString(),
                    coursedescr.getText().toString());
            staticDB.insert(newCourse, "Courses");

            //data[0]= courseName.getText().toString();
            //data[1] = courseloc.getText().toString();
            //data[2] = coursedescr.getText().toString();

            startActivity(new Intent(AddCourse.this, ListOfCourses.class));
        }

    }
}
