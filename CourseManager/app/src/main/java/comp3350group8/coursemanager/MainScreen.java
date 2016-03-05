package comp3350group8.coursemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import comp3350group8.coursemanager.R;

public class MainScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        SQLDatabase db = new SQLDatabase(this);

        staticDB.init();
    }

    public void buttonOnClick (View v)
    {

        startActivity(new Intent(MainScreen.this, ListOfCourses.class));

    }
}
