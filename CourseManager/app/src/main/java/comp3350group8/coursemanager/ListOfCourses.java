package comp3350group8.coursemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import comp3350group8.coursemanager.R;


/**
 * Created by David on 2016-02-17.
 */
public class ListOfCourses extends Activity {
    public static AppDatabase db;
    private ListView lv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofcourses);
        staticDB.createTable("Courses");

        //Bundle info = getIntent().getExtras();

        lv = (ListView) findViewById(R.id.listView);
        //String[] course= {"COMP 1010", "COMP 1020", "COMP 2130","COMP 2140", "COMP 2150"};
        String[] course = staticDB.getTable("Courses");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter);
    }
    public void buttonOnClick (View v)
    {
        startActivity(new Intent(ListOfCourses.this, AddCourse.class));

    }
}
