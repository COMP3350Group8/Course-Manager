package comp3350group8.coursemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.R;

public class MainScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        SQLDatabase db = new SQLDatabase(this);
        staticDB.init();
    }



    public void buttonOnClick (View v)//when a new account is created
    {
        SQLDatabase db = new SQLDatabase(this);
        EditText name, password, studentNum, email, school;
        name = (EditText) findViewById(R.id.name);
        password= (EditText) findViewById(R.id.password);
        studentNum = (EditText) findViewById(R.id.studentNum);
        email = (EditText) findViewById(R.id.emailAddress);
        school = (EditText) findViewById(R.id.school);

        User newUser = new User(name.toString(),password.toString(), studentNum.toString(),
                email.toString(),school.toString());
        db.insertUser(newUser);
        startActivity(new Intent(MainScreen.this, ListOfCourses.class));
    }

    public void buttonOnClick2 (View v)//code when user decides to log in
    {
        startActivity(new Intent(MainScreen.this, LoginActivity.class));

    }
}
