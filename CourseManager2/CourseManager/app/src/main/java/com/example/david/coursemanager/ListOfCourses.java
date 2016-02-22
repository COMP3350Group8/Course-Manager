package com.example.david.coursemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by David on 2016-02-17.
 */
public class ListOfCourses extends Activity {

    private ListView lv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofcourses);

        lv = (ListView) findViewById(R.id.listView);
        String[] course= {"COMP 1010", "COMP 1020", "COMP 2130","COMP 2140", "COMP 2150"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        lv.setAdapter(adapter);
    }
    public void buttonOnClick (View v)
    {
        startActivity(new Intent(ListOfCourses.this, AddCourse.class));

    }
}
