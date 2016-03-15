package comp3350group8.coursemanager.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.R;

public class LoginActivity extends AppCompatActivity {

    Button blogin;
    EditText email, etPassword;
    private SQLDatabase db = new SQLDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.etuserName);
        etPassword =(EditText) findViewById(R.id.etPassword);
        blogin =(Button) findViewById(R.id.bLogin);
        //User user = db.getUser(email, etPassword);
    }

    public void buttonOnClick(View v)
    {
        startActivity(new Intent(LoginActivity.this, ListOfCourses.class));
    }
}
