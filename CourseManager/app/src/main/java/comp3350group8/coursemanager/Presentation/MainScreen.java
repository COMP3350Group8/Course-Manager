package comp3350group8.coursemanager.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.Business.CurrentUser;
import comp3350group8.coursemanager.Persistence.StubDatabase;
import comp3350group8.coursemanager.R;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Business.User;
import comp3350group8.coursemanager.Persistence.staticDB;

public class MainScreen extends AppCompatActivity {
    private SQLDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        db = new SQLDatabase(this);
        staticDB.init();
    }



    public void buttonOnClick (View v)//when a new account is created
    {
        //SQLDatabase db = new SQLDatabase(this);
        EditText name, password, studentNum, email, school;
        name = (EditText) findViewById(R.id.name);
        password= (EditText) findViewById(R.id.password);
        studentNum = (EditText) findViewById(R.id.studentNum);
        email = (EditText) findViewById(R.id.emailAddress);
        school = (EditText) findViewById(R.id.school);

        //String name, String password, String studentNum, String email, String school
        User newUser = new User(name.getText().toString(), password.getText().toString(), studentNum.getText().toString()
                , email.getText().toString(), school.getText().toString());
        CurrentUser.setUser(email.getText().toString());
        Log.d("DEBUG", newUser.toString());
        long success = db.insertUser(newUser);

        if (success > 0) {
            startActivity(new Intent(MainScreen.this, ListOfCourses.class));
        } else {
            startActivity(new Intent(MainScreen.this, MainScreen.class));
        }
    }

    public void buttonOnClick2 (View v)//code when user decides to log in
    {
        startActivity(new Intent(MainScreen.this, LoginActivity.class));

    }
}
