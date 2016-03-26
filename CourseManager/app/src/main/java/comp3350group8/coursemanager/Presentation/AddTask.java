package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;


/**
 * Created by Anthony on 2016-03-08.
 */
public class AddTask extends AppCompatActivity {
    private SQLDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        db = new SQLDatabase(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);
        setTitle("Add Task");
    }

    //Back Button
    public void button5OnClick(View v) {
        //startActivity(new Intent(AddTask.this, TaskList.class));
        finish();
    }

    //Save Task Button
    public void button6OnClick(View v) {
        // retrieve the data supplied to the form
        EditText taskName = (EditText) findViewById(R.id.taskName);
        if (taskName.getText().length() == 0) {
            taskName.setError("Enter task");
        } else {
            EditText taskduedate = (EditText) findViewById(R.id.taskDueDate);

            EditText taskduetime = (EditText) findViewById(R.id.taskDueTime);

            EditText taskWeight = (EditText) findViewById(R.id.weight);
            String w = taskWeight.getText().toString();
            double weight = Double.parseDouble(w);

            // create instance of Task and send to the database
            Task newTask = new Task(taskName.getText().toString(),
                    taskduedate.getText().toString(),
                    taskduetime.getText().toString(),
                    weight);
            Log.d("DEBUG", newTask.toString());
            db.insertTask(newTask);

            startActivity(new Intent(AddTask.this, TaskList.class));
        }
    }
}
