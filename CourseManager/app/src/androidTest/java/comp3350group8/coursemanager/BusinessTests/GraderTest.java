package comp3350group8.coursemanager.BusinessTests;

import android.util.Log;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Grader;
import comp3350group8.coursemanager.Business.Task;

/**
 * Created by Ian Smith on 2016-03-27.
 */
public class GraderTest extends TestCase {
    public void testGrader() {
        ArrayList<Task> tasks = new ArrayList<Task>();

        // should be able to handle task that is irrelevant
        Task first =new Task("Assign1", "", "", 0);
        first.setScore(1);
        Log.d("DEBUG", "first = " + first.getActualScore());
        tasks.add(first);

        String g = Grader.setGrade(tasks);
        assertNotNull(g);
        String w = Grader.setRemainingWeight(tasks);
        assertNotNull(w);

        Log.d("DEBUG", "score = " + g + "\nweight remaining = " + w);

        Task second = new Task("Assign2", "", "", 0.5);
        second.setScore(1);
        tasks.add(second);

        g = Grader.setGrade(tasks);
        w = Grader.setRemainingWeight(tasks);

        Log.d("DEBUG", "score = " + g + "\nweight remaining = " + w);

        Task third = new Task("Assign3", "", "", 0.3);
        third.setScore(0.5);
        tasks.add(third);

        g = Grader.setGrade(tasks);
        w = Grader.setRemainingWeight(tasks);

        Log.d("DEBUG", "score = " + g + "\nweight remaining = " + w);
    }
}
