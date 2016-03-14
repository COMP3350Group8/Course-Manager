package comp3350group8.coursemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import comp3350group8.coursemanager.R;


/**
 * Created by Anthony on 2016-03-08.
 */
public class TaskList extends Activity {
    public static AppDatabase db;
    private ListView lv;

    //Back Button
    public void button3OnClick (View v)
    {
        startActivity(new Intent(TaskList.this, listofcourses.class));

    }

    //Add Task Button
    public void button4OnClick (View v)
    {
        startActivity(new Intent(TaskList.this, AddTask.class));
    }
}
