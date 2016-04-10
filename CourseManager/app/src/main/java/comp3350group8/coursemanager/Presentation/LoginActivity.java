package comp3350group8.coursemanager.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import comp3350group8.coursemanager.Business.CurrentUser;
import comp3350group8.coursemanager.Business.User;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;

public class LoginActivity extends AppCompatActivity {

    Button blogin;
    private Database db = staticDB.getDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        CurrentUser.reset();
    }


    public void login(View v)
    {
        EditText email, etPassword;
        email = (EditText) findViewById(R.id.etuserName);
        etPassword =(EditText) findViewById(R.id.etPassword);
        blogin =(Button) findViewById(R.id.bLogin);
        //if (!db.getUser(email.getText().toString().trim(), etPassword.getText().toString())
        User user = db.getUser(email.getText().toString().trim(), etPassword.getText().toString());
        Log.d("DEBUG", "" + (user == null));

        if (user != null) {
            CurrentUser.setUser(email.getText().toString().trim());
            startActivity(new Intent(LoginActivity.this, ListOfCourses.class));
        } else {
            email.setError("Email or Password is incorrect.");
        }

    }

    protected void onResume() {
        super.onResume();
        CurrentUser.reset();
    }

    public void home (View v)
    {
        startActivity(new Intent(LoginActivity.this, MainScreen.class));
    }
}
