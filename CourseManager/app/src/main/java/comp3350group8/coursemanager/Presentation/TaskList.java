package comp3350group8.coursemanager.Presentation;

import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import comp3350group8.coursemanager.Persistence.AppDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;


/**
 * Created by Anthony on 2016-03-08.
 */
public class TaskList extends Activity {
    private SQLDatabase db;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        db = new SQLDatabase(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist);

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.listView2);
        //String[] task= {"Do COMP 1020 Assignment", "Study for Database Exam", "Hand in Honesty Declaration"};


        // retrieve contents of "Tasks" if any
        //String[] task = staticDB.getTable("Tasks");
        ArrayList<Task> task = db.getTasks();
        Log.d("DEBUG", "Found " + task.size() + " tasks.");
        /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter); */
        String[] out = getTasks(task);
        Log.d("DEBUG", "" + out.length);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, out);
        lv.setAdapter(adapter);
    }

    public String[] getTasks(ArrayList<Task> tasks) {
        String[] list = new String[tasks.size()];

        for (int i = 0; i< tasks.size(); i++) {
            list[i] = tasks.get(i).getTaskName();
        }

        return list;
    }

    //Back Button
    public void button3OnClick (View v)
    {
        startActivity(new Intent(TaskList.this, ListOfCourses.class));

    }

    //Add Task Button
    public void button4OnClick (View v)
    {
        startActivity(new Intent(TaskList.this, AddTask.class));
    }
}
