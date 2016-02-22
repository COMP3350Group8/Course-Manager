package com.example.david.coursemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by David on 2016-02-17.
 */
public class AddCourse extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);

    }
    public void buttonOnClick (View v)
    {
        //EditText courseName = (EditText) findViewById(R.id.courseName);

        startActivity(new Intent(AddCourse.this, ListOfCourses.class));

    }
}
