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
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;

public class TaskDetail extends AppCompatActivity {
    private Database db = staticDB.getDB();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_detail);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        db = new SQLDatabase(this);
        Task curr = CurrentTask.getTask();
        EditText text = null;

        // get curr's information
        String[] output = {curr.getName(), curr.getDate(), curr.getTime(), "" + curr.getWeight(), "unknown"};

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

    public void saveTaskOnClick(View v) {
        //collect info from page
        EditText taskName = (EditText) findViewById(R.id.taskName);

        EditText taskduedate = (EditText) findViewById(R.id.taskDueDate);

        EditText taskduetime = (EditText) findViewById(R.id.taskDueTime);

        EditText taskWeight = (EditText) findViewById(R.id.taskWeight);
        String w = taskWeight.getText().toString();
        double weight = Double.parseDouble(w);


        // create instance of Task and send to the database
        Task newTask = new Task(taskName.getText().toString(),
            taskduedate.getText().toString(),
            taskduetime.getText().toString(),
            weight);
        Log.d("DEBUG", newTask.toString());

        EditText taskScore = (EditText) findViewById(R.id.taskScore);
        String s = taskScore.getText().toString();
        newTask.setScore(Double.parseDouble(s));
        newTask.setID(CurrentTask.getTask().getID());

        db.updateTask(newTask);
        startActivity(new Intent(TaskDetail.this, TaskList.class));
    }

    public void buttonOnClick2 (View v)
    {
        startActivity(new Intent(TaskDetail.this, ListOfCourses.class));
    }

}
