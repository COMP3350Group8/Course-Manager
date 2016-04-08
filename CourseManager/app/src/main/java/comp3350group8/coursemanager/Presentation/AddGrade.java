package comp3350group8.coursemanager.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.CurrentCourse;
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
            long current = CurrentCourse.getID();
            int id = (int) current;

            Course curr = db.getCourse(id);
            LetterGrade lGrade = new LetterGrade(grade);
            Log.d("Grade", "lGrade = " + lGrade.toString());
            Log.d("DEBUG", "curr.id = " + curr.getID());
            curr.setGrade(lGrade);
            Log.d("DEBUG", "Graded course = " + curr);

            //boolean updateCourse(Course course)
            boolean success = db.updateCourse(curr);

            if (success) {
                startActivity(new Intent(AddGrade.this, TaskList.class));
            } else {
                Log.d("DEBUG", "Couldn't update the course data");
            }

        }
    }

}
