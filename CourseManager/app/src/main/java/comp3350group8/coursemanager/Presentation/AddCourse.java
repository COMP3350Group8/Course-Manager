package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;
import comp3350group8.coursemanager.R;
import comp3350group8.coursemanager.Persistence.staticDB;

/**
 * Created by David on 2016-02-17.
 */
public class AddCourse extends AppCompatActivity {
    private Database db = staticDB.getDB();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);
        setTitle("Add Course");

        final Button courseTime = (Button) findViewById(R.id.timeBtn);
        courseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TimePicker tm = new TimePicker(AddCourse.this);
                AlertDialog.Builder adb = new AlertDialog.Builder(AddCourse.this);

                adb.setTitle("Set Time")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int hour = tm.getCurrentHour();
                                int min = tm.getCurrentMinute();
                                String AM_PM;

                                if (hour < 12) {
                                    AM_PM = "AM";
                                } else {
                                    AM_PM = "PM";
                                    hour = (hour == 0) ? 12 : hour - 12;
                                }
                                if (min < 10)
                                    courseTime.setText(hour + ":0" + min + " " + AM_PM);
                                else
                                    courseTime.setText(hour + ":" + min + " " + AM_PM);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and r
                LayoutInflater inflater = AddCourse.this.getLayoutInflater();
                LinearLayout layout;
                //time = new TimePicker(add_info.this);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                layout = new LinearLayout(AddCourse.this);
                //View view = new View(add_info.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(tm, params);
                adb.setView(layout);
                Dialog d = adb.create();
                d.show();
                tm.clearFocus();
            }
        });
    }
    //final Intent newActivity = new Intent(AddCourse.this, ListOfCourses.class);
    public void AddCourse (View v)
    {
        CheckBox ch1 = (CheckBox)findViewById(R.id.checkBoxMWF);
        CheckBox ch2 = (CheckBox)findViewById(R.id.checkBoxTTh);
        String courseDate = "";
        // String []data = new String[3];

        // retrieve the data supplied to the form
        EditText courseName = (EditText) findViewById(R.id.courseName);
        if(courseName.length() ==  0) {
            courseName.setError("Enter course");
        } else {
            EditText courseloc = (EditText) findViewById(R.id.location);
            EditText coursedescr = (EditText) findViewById(R.id.description);
            EditText courseCredits = (EditText) findViewById(R.id.credits);
            String credits = courseCredits.getText().toString();

            if (ch1.isChecked()){
                //If checked, course is on MWF
                courseDate = "M-W-F";
            }

            if (ch2.isChecked()){
                //If checked, course is on T/Th
                courseDate = "T-Th";
            }

            try {
                int c = Integer.valueOf(credits);

                if (c >= 0) {
                    // create instance of Course and send to the database
                    Course newCourse = new Course(courseName.getText().toString(),
                            courseloc.getText().toString(),
                            coursedescr.getText().toString(),
                            courseDate,
                            c);

                    long insert = db.insertCourse(newCourse);

                    if (insert > 0) {
                        startActivity(new Intent(AddCourse.this, ListOfCourses.class));
                    } else {
                        Log.d("DEBUG", "Insertion of course: " + newCourse + "\n failed");
                    }
                } else {
                    courseCredits.setError("Credit Hours must be represented as a positive number");
                }
            } catch (NumberFormatException e) {
                courseCredits.setError("Credit Hours must be represented as a number");
            }
        }

    }
}
