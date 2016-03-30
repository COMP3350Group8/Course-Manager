package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
                        EditText taskduedate = (EditText) findViewById(R.id.taskDueDate);
                        EditText taskduetime = (EditText) findViewById(R.id.taskDueTime);

                        // create instance of Task and send to the database
                        Task newTask = new Task(taskName.getText().toString(),
                                taskduedate.getText().toString(),
                                taskduetime.getText().toString(),
                                weight);
                        Log.d("DEBUG", newTask.toString());
                        db.insertTask(newTask);
                        startActivity(new Intent(AddTask.this, TaskList.class));
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
