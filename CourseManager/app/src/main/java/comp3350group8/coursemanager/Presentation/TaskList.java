package comp3350group8.coursemanager.Presentation;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentTask;
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
    private SQLDatabase db;
    private ArrayList<Task> tasks;
    private ListView lv;
    
    protected void onCreate(Bundle savedInstanceState) {
        db = new SQLDatabase(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist);

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.TaskList);
        //String[] task= {"Do COMP 1020 Assignment", "Study for Database Exam", "Hand in Honesty Declaration"};


        // retrieve contents of "Tasks" if any
        //String[] task = staticDB.getTable("Tasks");
        tasks = db.getTasks();
        Log.d("DEBUG", "Found " + tasks.size() + " tasks.");
        /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter); */
        String[] out = getTasks(tasks);
        Log.d("DEBUG", "" + out.length);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, out);
        lv.setAdapter(adapter);

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

        // TODO: set grade function
        setGrade();

        // TODO: set remaining weight
        setRemainingWeight();
    }

    public void setGrade() {
        // get total weights and total scores
        double totalWeight = 0;
        double totalScore = 0;
        double loopscore = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            totalWeight += curr.getWeight();
            //totalScore += curr.getScore();
            totalScore += curr.getActualScore();
        }

        double actualScore = totalScore / totalWeight;
        Log.d("DEBUG", "score = " + totalScore);
        Log.d("DEBUG", "weight = " + totalWeight);
        String actual = "" + (actualScore * 100) + "%";

        TextView s = (TextView) findViewById(R.id.CourseGrade);
        s.setText(actual, TextView.BufferType.NORMAL);
    }

    public void setRemainingWeight() {
        double totalWeight = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            totalWeight += curr.getWeight();
        }

        double remains = 1 - totalWeight;
        String remainsString = "" + remains + " remaining";
        TextView remaining = (TextView) findViewById(R.id.Remaining);
        remaining.setText(remainsString, TextView.BufferType.NORMAL);
    }

    public String[] getTasks(ArrayList<Task> tasks) {
        String[] list = new String[tasks.size()];

        for (int i = 0; i< tasks.size(); i++) {
            list[i] = tasks.get(i).getTaskName();
        }

        return list;
    }

    // Add Task Button
    public void AddTask (View v)
    {
        startActivity(new Intent(TaskList.this, AddTask.class));
    }
}
