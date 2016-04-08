package comp3350group8.coursemanager.Presentation;

import comp3350group8.coursemanager.Business.ArrayConverter;
import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentTask;
import comp3350group8.coursemanager.Business.Grader;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.staticDB;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350group8.coursemanager.R;


/**
 * Created by Anthony on 2016-03-08.
 */
public class TaskList extends Activity {
    private Database db = staticDB.getDB();
    private ArrayList<Task> tasks;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist);

        Button addGrade = (Button) findViewById(R.id.AddGrade);
        addGrade.setVisibility(View.INVISIBLE);

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.TaskList);
        //String[] task= {"Do COMP 1020 Assignment", "Study for Database Exam", "Hand in Honesty Declaration"};

        Log.d("DEBUG", "course = " + CurrentCourse.getCourseName() + ", " + CurrentCourse.getID());

        Course curr = db.getCourse((int)CurrentCourse.getID());
        String description = curr.toString();
        Log.d("DEBUG", "Description = " + description);
        TextView desc = (TextView)findViewById(R.id.CourseDescription);
        desc.setText(description, TextView.BufferType.NORMAL);

        tasks = db.getTasks();
        Log.d("DEBUG", "Found " + tasks.size() + " tasks.");

        String[] out = ArrayConverter.convertTasks(tasks);
        Log.d("DEBUG", "" + out.length);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, out);
        lv.setAdapter(adapter);

        String grade = Grader.setGrade(tasks);
        TextView s = (TextView) findViewById(R.id.CourseGrade);
        s.setText(grade, TextView.BufferType.NORMAL);

        double remainingDouble = Grader.setRemainingWeight(tasks);
        String remaining = "" + remainingDouble + " remaining";
        TextView r = (TextView) findViewById(R.id.Remaining);
        r.setText(remaining, TextView.BufferType.NORMAL);

        if (remainingDouble <= 0) {
            Button taskAdd = (Button)findViewById(R.id.AddTask);
            //taskAdd.setEnabled(false);
            taskAdd.setVisibility(View.INVISIBLE);

            addGrade.setVisibility(View.VISIBLE);
        }

        //TODO: maybe use a function pointer for this?
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

    public void AddTask (View v) {
        startActivity(new Intent(TaskList.this, AddTask.class));
    }

    public void AddGrades (View v) {
        startActivity(new Intent(TaskList.this, MainScreen.class));
    }

    public void CourseList (View v) {
        startActivity(new Intent(TaskList.this, ListOfCourses.class));
    }

    public void addGrade(View v) {
        startActivity(new Intent(TaskList.this, AddGrade.class));
    }
}
