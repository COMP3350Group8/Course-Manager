package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;
import comp3350group8.coursemanager.TaskList;

/**
 * Created by Anthony on 2016-03-08.
 */
public class AddTask extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask);


    }

    //Back Button
    public void button5OnClick (View v)
    {
        startActivity(new Intent(AddTask.this, TaskList.class));

    }

    //Save Task Button
    public void button6OnClick (View v)
    {
        // String []data = new String[3];

        // retrieve the data supplied to the form
        EditText taskName = (EditText) findViewById(R.id.taskName);
        if(taskName.getText().length() ==  0) {
            taskName.setError("Enter task");
        }
        else {
            EditText taskduedate = (EditText) findViewById(R.id.taskDueDate);

            EditText taskduetime = (EditText) findViewById(R.id.taskDueTime);

            // create instance of Task and send to the database
            Task newTask = new Task(taskName.getText().toString(),
                    taskduedate.getText().toString(),
                    taskduetime.getText().toString());
            staticDB.insert(newTask, "Tasks");

            //data[0]= taskName.getText().toString();
            //data[1] = taskduedate.getText().toString();
            //data[2] = taskduetime.getText().toString();
            startActivity(new Intent(AddTask.this, TaskList.class));

        }
    }
