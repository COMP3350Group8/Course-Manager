package comp3350group8.coursemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button blogin;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etuserName);
        etPassword =(EditText) findViewById(R.id.etPassword);
        blogin =(Button) findViewById(R.id.bLogin);
    }

    public void buttonOnClick(View v)
    {
        startActivity(new Intent(LoginActivity.this, ListOfCourses.class));
    }
}
