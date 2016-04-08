package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import comp3350group8.coursemanager.Business.Grader;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;


/**
 * Created by Anthony on 2016-03-08.
 */
public class AddTask extends AppCompatActivity {
    private Database db = staticDB.getDB();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        setTitle("Add Task");


        final Button taskduetime = (Button) findViewById(R.id.timeBtn);
        taskduetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TimePicker tm = new TimePicker(AddTask.this);
                AlertDialog.Builder adb = new AlertDialog.Builder(AddTask.this);

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
                                taskduetime.setText(hour + ":" + min + " " + AM_PM);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and r
                LayoutInflater inflater = AddTask.this.getLayoutInflater();
                LinearLayout layout;
                //time = new TimePicker(add_info.this);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                layout = new LinearLayout(AddTask.this);
                //View view = new View(add_info.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(tm, params);
                adb.setView(layout);
                Dialog d = adb.create();
                d.show();
                tm.clearFocus();
            }
        });

        final Button taskduedate = (Button) findViewById(R.id.dateBtn);
        taskduedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatePicker dm = new DatePicker(AddTask.this);
                AlertDialog.Builder adb = new AlertDialog.Builder(AddTask.this);

                adb.setTitle("Set Time")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int year = dm.getYear();
                                int month = dm.getMonth();
                                int day = dm.getDayOfMonth();

                                taskduedate.setText(day + "/" + month + "/" + year);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and r
                LayoutInflater inflater = AddTask.this.getLayoutInflater();
                LinearLayout layout;
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                layout = new LinearLayout(AddTask.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(dm, params);
                adb.setView(layout);
                Dialog d = adb.create();
                d.show();
                dm.clearFocus();
            }
        });
    }

    public void Back(View v) {
        //startActivity(new Intent(AddTask.this, TaskList.class));
        finish();
    }

    public void SaveTask(View v) {
        double remainingWeight = Grader.getRemainingWeight();
        // retrieve the data supplied to the form
        EditText taskName = (EditText) findViewById(R.id.taskName);
        EditText taskWeight = (EditText) findViewById(R.id.weight);

        boolean hasWeight =  taskWeight.length() > 0;
        boolean hasName = taskName.length() > 0;

        if (!hasWeight || !hasName) {
            if (hasWeight) {
                taskName.setError("Enter task");
            } else {
                taskWeight.setError("Enter weight");
            }
        } else {
            String w = taskWeight.getText().toString();
            try {
                double weight = Double.valueOf(w);

                if (weight <= 1 && weight >= 0) {
                    boolean exceedsRemainingWeight = remainingWeight - weight < 0;

                    if (!exceedsRemainingWeight) {

                        Button taskduedate = (Button) findViewById(R.id.dateBtn);
                        Button taskduetime  = (Button) findViewById(R.id.timeBtn);

                        // create instance of Task and send to the database
                        Task newTask = new Task(taskName.getText().toString(),
                                taskduedate.getText().toString(),
                                taskduetime.getText().toString(),
                                weight);

                        Log.d("DEBUG", newTask.toString());
                        long insert = db.insertTask(newTask);;
                        Log.d("DEBUG", "insertion is successful if > 0: " + insert);

                        if (insert > 0) {
                            startActivity(new Intent(AddTask.this, TaskList.class));
                        }
                    } else {
                        taskWeight.setError("The weight of this task cannot exceed " + remainingWeight);
                    }
                } else {
                    taskWeight.setError("Enter a Task Weight between 0 and 1");
                }
            } catch (NumberFormatException e) {
                taskWeight.setError("Must be valid decimal number");
            }
        }
    }
}
