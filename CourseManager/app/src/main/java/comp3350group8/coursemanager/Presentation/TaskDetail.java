package comp3350group8.coursemanager.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentTask;
import comp3350group8.coursemanager.Business.Grader;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;

public class TaskDetail extends AppCompatActivity {
    private Database db = staticDB.getDB();
    private double oldWeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_detail);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Task curr = CurrentTask.getTask();
        EditText text = null;

        String[] output = {curr.getName(), curr.getDate(), curr.getTime(), "" + curr.getWeight(), "unknown"};
        oldWeight = curr.getWeight();

        if (curr.getScore() != 0) {
            output[4] = "" + curr.getScore();
            double actual = curr.getScore() * curr.getWeight();

            text = (EditText)findViewById(R.id.taskScore);
            text.setText(output[4], TextView.BufferType.EDITABLE);

            TextView t = (TextView)findViewById(R.id.PercentageGrade);
            String actualString = "" + actual;
            t.setText(actualString, TextView.BufferType.NORMAL);
        }

        // render curr to page
        text = (EditText)findViewById(R.id.taskName);
        text.setText(output[0], TextView.BufferType.EDITABLE);

        text = (EditText)findViewById(R.id.taskDueDate);
        text.setText(output[1], TextView.BufferType.EDITABLE);

        text = (EditText)findViewById(R.id.taskDueTime);
        text.setText(output[2], TextView.BufferType.EDITABLE);

        text = (EditText)findViewById(R.id.taskWeight);
        text.setText(output[3], TextView.BufferType.EDITABLE);
    }

    public void saveTask(View v) {
        //collect info from page
        EditText taskName = (EditText) findViewById(R.id.taskName);
        EditText taskduedate = (EditText) findViewById(R.id.taskDueDate);
        EditText taskduetime = (EditText) findViewById(R.id.taskDueTime);
        EditText taskWeight = (EditText) findViewById(R.id.taskWeight);

        boolean hasWeight = taskWeight.length() > 0;
        boolean hasName = taskName.length() > 0;

        if (hasWeight && hasName) {
            String w = taskWeight.getText().toString();
            try {
                double weight = Double.valueOf(w);
                Log.d("WEIGHT", "weight = " + weight);

                if (weight >= 0 && weight <= 1) {
                    double remainingWeight = Grader.getRemainingWeight();
                    Log.d("WEIGHT", "remainingWeight = " + remainingWeight + "\nweight = " + weight);

                    if (weight <= remainingWeight + oldWeight) {
                        Task newTask = new Task(taskName.getText().toString(),
                                taskduedate.getText().toString(),
                                taskduetime.getText().toString(),
                                weight);
                        Log.d("DEBUG", newTask.toString());

                        EditText taskScore = (EditText) findViewById(R.id.taskScore);

                        if (taskScore.length() > 0) {
                            String s = taskScore.getText().toString();
                            try {
                                double score = Double.valueOf(s);

                                if (score >= 0 && score <= 1) {
                                    newTask.setScore(Double.parseDouble(s));
                                    newTask.setID(CurrentTask.getTask().getID());

                                    db.updateTask(newTask);
                                    startActivity(new Intent(TaskDetail.this, TaskList.class));
                                } else {
                                    taskScore.setError("Task Score must be between 0 and 1");
                                }
                            } catch(NumberFormatException e) {
                                taskScore.setError("Enter valid decimal number");
                            }
                        } else {
                            db.updateTask(newTask);
                            startActivity(new Intent(TaskDetail.this, TaskList.class));
                        }
                    } else {
                        taskWeight.setError("Task Weight cannot exceed " + remainingWeight);
                    }
                } else {
                    taskWeight.setError("Enter a Task Weight between 0 and 1");
                }
            } catch(NumberFormatException e) {
                taskWeight.setError("Must be valid decimal number");
            }
        } else {
            if (hasName) {
                taskName.setError("Enter Task Name");
            } else {
                taskWeight.setError("Enter Task Weight");
            }
        }
    }


    public void ReturnToCourseList(View v) {
        startActivity(new Intent(TaskDetail.this, ListOfCourses.class));
    }

}
