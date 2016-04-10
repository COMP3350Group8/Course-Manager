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
import android.widget.TextView;

import comp3350group8.coursemanager.Business.CurrentCourse;
import comp3350group8.coursemanager.Business.CurrentTask;
import comp3350group8.coursemanager.Business.Grader;
import comp3350group8.coursemanager.Business.RoundNumber;
import comp3350group8.coursemanager.Business.Task;
import comp3350group8.coursemanager.Persistence.Database;
import comp3350group8.coursemanager.Persistence.SQLDatabase;
import comp3350group8.coursemanager.Persistence.staticDB;
import comp3350group8.coursemanager.R;

public class TaskDetail extends AppCompatActivity {
    private Database db = staticDB.getDB();
    private double oldWeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_detail);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Task curr = CurrentTask.getTask();
        EditText text = null;

        String[] output = {curr.getName(), curr.getDate(), curr.getTime(), "" + curr.getWeight(), ""};
        oldWeight = curr.getWeight();

        if (curr.getScore() != 0) {
            Log.d("DEBUG", "score = " + curr.getScore() + ", weight = " + curr.getWeight());
            double score = curr.getScore() * curr.getWeight() * 100;
            RoundNumber rounderNumber = new RoundNumber(score);
            score = rounderNumber.roundTo(10);
            output[4] = "" + score;

            double p = score / curr.getWeight();
            rounderNumber = new RoundNumber(p);
            p = rounderNumber.roundTo(10000);
            String percentage = "" + p + "%";
//            double actual = curr.getScore() * curr.getWeight()*100;
            Log.d("DEBUG", "score = " + curr.getScore() + ", result = " + output[4] + ", weight = " + curr.getWeight());

            text = (EditText)findViewById(R.id.taskScore);
            text.setText(output[4], TextView.BufferType.EDITABLE);

            TextView t = (TextView)findViewById(R.id.PercentageGrade);
//            String actualString = "" + actual + "%";
            t.setText(percentage, TextView.BufferType.NORMAL);
        }

        text = (EditText)findViewById(R.id.taskName);
        text.setText(output[0], TextView.BufferType.EDITABLE);

        text = (EditText)findViewById(R.id.taskDueDate);
        text.setText(output[1], TextView.BufferType.EDITABLE);

        text = (EditText)findViewById(R.id.taskDueTime);
        text.setText(output[2], TextView.BufferType.EDITABLE);
        Log.d("DEBUG", "weight " + output[3]);
        text = (EditText)findViewById(R.id.taskWeight);
        text.setText("/" + Double.parseDouble(output[3])*100, TextView.BufferType.EDITABLE);
    }

    public void saveTask(View v) {
        EditText taskName = (EditText) findViewById(R.id.taskName);
        EditText taskduedate = (EditText) findViewById(R.id.taskDueDate);
        EditText taskduetime = (EditText) findViewById(R.id.taskDueTime);
        EditText taskWeight = (EditText) findViewById(R.id.taskWeight);

        boolean hasWeight = taskWeight.length() > 0;
        boolean hasName = taskName.length() > 0;

        if (hasWeight && hasName) {
            String w = taskWeight.getText().toString().replaceAll("[/%]","");
            Log.d("WEIGHT", "123weight = " + w);
            try {
                double weight = Double.valueOf(w);
                weight = weight / 100;
                Log.d("WEIGHT", "weight = " + weight);

                if (weight >= 0 && weight <= 1) {
                    double remainingWeight = Grader.getRemainingWeight();
                    Log.d("WEIGHT", "remainingWeight = " + remainingWeight + "\nweight = " + weight);

                    if (weight <= remainingWeight + oldWeight) {
                        Task newTask = new Task(taskName.getText().toString(),
                                taskduedate.getText().toString(),
                                taskduetime.getText().toString(),
                                weight);
                        saveTaskToDatabase(newTask, w);
                    } else {
                        taskWeight.setError("Task Weight cannot exceed " + remainingWeight*100);
                    }
                } else {
                    taskWeight.setError("Enter a Task Weight between 0 and 100");
                }
            } catch(NumberFormatException e) {
                taskWeight.setError("Must be valid decimal number");
            }
        } else {
            if (hasName) {
                taskName.setError("Enter Task Name");
            } else {
                taskWeight.setError("Enter Task Weight");
            }
        }
    }

    private void saveTaskToDatabase(Task newTask, String weight) {
        Log.d("DEBUG", newTask.toString());

        EditText taskScore = (EditText) findViewById(R.id.taskScore);

        if (taskScore.length() > 0) {
            String s = taskScore.getText().toString();
            try {
                double score = Double.valueOf(s);

                if (score >= 0 && score <= Double.valueOf(weight)) {
                    newTask.setScore(Double.parseDouble(s)/Double.valueOf(weight));
                    newTask.setID(CurrentTask.getTask().getID());

                    db.updateTask(newTask);
                    startActivity(new Intent(TaskDetail.this, TaskList.class));
                } else {
                    taskScore.setError("Task Score must be between 0 and " + weight);
                }
            } catch(NumberFormatException e) {
                taskScore.setError("Enter valid decimal number");
            }
        } else {
            db.updateTask(newTask);
            startActivity(new Intent(TaskDetail.this, TaskList.class));
        }
    }


    public void ReturnToCourseList(View v) {
        startActivity(new Intent(TaskDetail.this, ListOfCourses.class));
    }

}
