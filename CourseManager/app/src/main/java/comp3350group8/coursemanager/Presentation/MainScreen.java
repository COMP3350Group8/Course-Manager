package comp3350group8.coursemanager.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.Business.CurrentUser;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.StubDatabase;
import comp3350group8.coursemanager.R;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Business.User;
import comp3350group8.coursemanager.Persistence.staticDB;

public class MainScreen extends AppCompatActivity {
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        staticDB.init(this);
        CurrentUser.reset();
        db = staticDB.getDB();
    }

    public void createAccount(View v)//when a new account is created
    {
        //SQLDatabase db = new SQLDatabase(this);
        EditText name, password, studentNum, email, school;
        name = (EditText) findViewById(R.id.name);
        password= (EditText) findViewById(R.id.password);
        studentNum = (EditText) findViewById(R.id.studentNum);
        email = (EditText) findViewById(R.id.emailAddress);
        school = (EditText) findViewById(R.id.school);

        boolean hasEmail = email.length() > 0;
        boolean hasStudentNum = studentNum.length() > 0;

        if (hasEmail && hasStudentNum) {
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
        } else {
            if (hasEmail) {
                studentNum.setError("Enter Student Number");
            } else {
                email.setError("Enter Email Address");
            }
        }
    }

    public void login(View v) {
        startActivity(new Intent(MainScreen.this, LoginActivity.class));
    }

    protected void onResume() {
        super.onResume();
        CurrentUser.reset();
    }
}
