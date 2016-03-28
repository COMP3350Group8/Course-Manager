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
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;

public class LoginActivity extends AppCompatActivity {

    Button blogin;
    private SQLDatabase db = staticDB.getDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void buttonOnClick(View v)
    {
        EditText email, etPassword;
        email = (EditText) findViewById(R.id.etuserName);
        etPassword =(EditText) findViewById(R.id.etPassword);
        blogin =(Button) findViewById(R.id.bLogin);

        User user = db.getUser(email.getText().toString(), etPassword.getText().toString());
        Log.d("DEBUG", "" + (user == null));

        if (user != null) {
            CurrentUser.setUser(email.getText().toString());
            startActivity(new Intent(LoginActivity.this, ListOfCourses.class));
        }
    }
}
