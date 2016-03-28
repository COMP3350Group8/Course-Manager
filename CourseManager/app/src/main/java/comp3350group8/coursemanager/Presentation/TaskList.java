package comp3350group8.coursemanager.Presentation;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentTask;
import comp3350group8.coursemanager.Business.Grader;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.StubDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import comp3350group8.coursemanager.Persistence.AppDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;


/**
 * Created by Anthony on 2016-03-08.
 */
public class TaskList extends Activity {
    private SQLDatabase db = staticDB.getDB();
    private ArrayList<Task> tasks;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist);
//        db = new SQLDatabase(this);

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.TaskList);
        //String[] task= {"Do COMP 1020 Assignment", "Study for Database Exam", "Hand in Honesty Declaration"};

        Log.d("DEBUG", "course = " + CurrentCourse.getCourseName() + ", " + CurrentCourse.getID());

        // retrieve contents of "Tasks" if any
        //String[] task = staticDB.getTable("Tasks");
        Course curr = db.getCourse((int)CurrentCourse.getID());
        String description = curr.toString();
        TextView desc = (TextView)findViewById(R.id.CourseDescription);
        desc.setText(description, TextView.BufferType.NORMAL);

        tasks = db.getTasks();
        Log.d("DEBUG", "Found " + tasks.size() + " tasks.");
        /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter); */
        String[] out = getTasks(tasks);
        Log.d("DEBUG", "" + out.length);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, out);
        lv.setAdapter(adapter);

        String grade = Grader.setGrade(tasks);
        TextView s = (TextView) findViewById(R.id.CourseGrade);
        s.setText(grade, TextView.BufferType.NORMAL);

        String remaining = Grader.setRemainingWeight(tasks);
        TextView r = (TextView) findViewById(R.id.Remaining);
        r.setText(remaining, TextView.BufferType.NORMAL);

        //select a task
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("DEBUG", "Selected course with id: " + id);
                if (id < Integer.MAX_VALUE && id > Integer.MIN_VALUE) {
                    int index = (int) id;
                    Task curr = tasks.get(index);
                    CurrentTask.setTask(curr);

                    Log.d("DEBUG", "course = " + CurrentCourse.getCourseName());
                }
                Object o = lv.getItemAtPosition(position);
                startActivity(new Intent(TaskList.this, TaskDetail.class));
                // Toast.makeText(ListOfCourses.this, o.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    //TODO: move out of controller
    public String[] getTasks(ArrayList<Task> tasks) {
        String[] list = new String[tasks.size()];

        for (int i = 0; i< tasks.size(); i++) {
            list[i] = tasks.get(i).getName();
        }

        return list;
    }

    // Add Task Button
    public void AddTask (View v)
    {
        startActivity(new Intent(TaskList.this, AddTask.class));
    }
}
