package comp3350group8.coursemanager.Presentation;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import comp3350group8.coursemanager.Persistence.AppDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;


/**
 * Created by Anthony on 2016-03-08.
 */
public class TaskList extends Activity {
    public static AppDatabase db;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist);

        // create task table
        staticDB.createTable("Tasks");

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.listView);
        //String[] task= {"Do COMP 1020 Assignment", "Study for Database Exam", "Hand in Honesty Declaration"};

        // retrieve contents of "Tasks" if any
        String[] course = staticDB.getTable("Tasks");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter);
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
