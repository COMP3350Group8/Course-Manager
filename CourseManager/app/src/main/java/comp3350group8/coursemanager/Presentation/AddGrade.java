package comp3350group8.coursemanager.Presentation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.Business.LetterGrade;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;

public class AddGrade extends AppCompatActivity {
    private Database db = staticDB.getDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addgrade);
        setTitle("Add Letter Grade");
    }

    public void addGrade(View v) {
        EditText letterGrade = (EditText) findViewById(R.id.AddGrade);

        if (letterGrade.length() != 1 && letterGrade.length() != 2) {
            letterGrade.setError("Invalid letter grade");
        } else {
            String grade = letterGrade.getText().toString();
            LetterGrade g = new LetterGrade(grade);

            //TODO: get the course and update it with the grade
        }
    }

}
