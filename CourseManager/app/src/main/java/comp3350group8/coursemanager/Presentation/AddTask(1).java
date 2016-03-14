package comp3350group8.coursemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.R;

/**
 * Created by Anthony on 2016-03-08.
 */
public class AddTask extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcourse);


    }

    //Back Button
    public void button5OnClick (View v)
    {
        startActivity(new Intent(AddTask.this, TaskList.class));

    }

    //Save Task Button
    public void button6OnClick (View v)
    {
        startActivity(new Intent(AddTask.this, TaskList.class));

    }
}
