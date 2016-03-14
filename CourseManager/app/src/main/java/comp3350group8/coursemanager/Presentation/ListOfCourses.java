package comp3350group8.coursemanager.Presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.ListAdapter;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.ListItem;
import comp3350group8.coursemanager.Business.SubTable;
import comp3350group8.coursemanager.Persistence.AppDatabase;
import comp3350group8.coursemanager.R;
import comp3350group8.coursemanager.Persistence.staticDB;


/**
 * Created by David on 2016-02-17.
 */
public class ListOfCourses extends Activity {
    public static AppDatabase db;
    private ListView lv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofcourses);

        // create course table
        staticDB.createTable("Courses");

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.listView);
        //String[] course= {"COMP 1010", "COMP 1020", "COMP 2130","COMP 2140", "COMP 2150"};

        // retrieve contents of "Courses" if any
       /*String[] course = staticDB.getTable("Courses");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter);
*/
        SubTable table = staticDB.searchTable("Courses");
        ArrayList<ListItem> items = table.getAll();
        lv.setAdapter(new myListAdapter(ListOfCourses.this, items));

        //select a course
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = lv.getItemAtPosition(position);
                Toast.makeText(ListOfCourses.this, o.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
    public void buttonOnClick (View v)
    {
        startActivity(new Intent(ListOfCourses.this, AddCourse.class));

    }
}