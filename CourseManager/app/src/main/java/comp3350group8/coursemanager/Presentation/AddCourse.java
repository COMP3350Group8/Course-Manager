package comp3350group8.coursemanager.Presentation;

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
import comp3350group8.coursemanager.R;
import comp3350group8.coursemanager.Persistence.staticDB;

/**
 * Created by David on 2016-02-17.
 */
public class AddCourse extends AppCompatActivity {
    private Database db = staticDB.getDB();
    private Button courseTime;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);
        setTitle("Add Course");

        courseTime = (Button) findViewById(R.id.timeBtn);
        courseTime.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
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
    };

    public void AddCourse (View v) {
        CheckBox ch1 = (CheckBox)findViewById(R.id.chkBoxM);
        CheckBox ch2 = (CheckBox)findViewById(R.id.chkBoxT);
        CheckBox ch3 = (CheckBox)findViewById(R.id.chkBoxW);
        CheckBox ch4 = (CheckBox)findViewById(R.id.chkBoxTh);
        CheckBox ch5 = (CheckBox)findViewById(R.id.chkBoxF);
        String courseDate = "";

        EditText courseName = (EditText) findViewById(R.id.courseName);
        if(courseName.length() ==  0) {
            courseName.setError("Enter course");
        } else {
            EditText courseloc = (EditText) findViewById(R.id.location);
            EditText coursedescr = (EditText) findViewById(R.id.description);
            EditText courseCredits = (EditText) findViewById(R.id.credits);

            String name = courseName.getText().toString();
            String location = courseloc.getText().toString();
            String description = coursedescr.getText().toString();
            String credits = courseCredits.getText().toString();

            if (ch1.isChecked()){
                courseDate += "M ";
            }

            if (ch2.isChecked()){
                courseDate += "T ";
            }

            if (ch3.isChecked()){
                courseDate += "W ";
            }

            if (ch4.isChecked()){
                courseDate += "Th ";
            }

            if (ch5.isChecked()){
                courseDate += "F ";
            }

            try {
                int c = Integer.valueOf(credits);

                if (c >= 0) {
                    // create instance of Course and send to the database
                    insertCourseIntoDatabase(name, location, description, courseDate, c);
                } else {
                    courseCredits.setError("Credit Hours must be represented as a positive number");
                }
            } catch (NumberFormatException e) {
                courseCredits.setError("Credit Hours must be represented as a number");
            }
        }

    }

    private void insertCourseIntoDatabase(String name, String location, String description, String date, int credits) {
        Course newCourse = new Course(name, location, description, date, credits);

        long insert = db.insertCourse(newCourse);

        if (insert > 0) {
            startActivity(new Intent(AddCourse.this, ListOfCourses.class));
        } else {
            Log.d("DEBUG", "Insertion of course: " + newCourse + "\n failed");
        }
    }
}
