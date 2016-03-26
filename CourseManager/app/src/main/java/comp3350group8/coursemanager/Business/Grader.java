package comp3350group8.coursemanager.Business;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350group8.coursemanager.R;

/**
 * Created by Ian Smith on 2016-03-25.
 */
public class Grader {
    public static String setGrade(ArrayList<Task> tasks) {
        // get total weights and total scores
        double totalWeight = 0;
        double totalScore = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            totalWeight += curr.getWeight();
            //totalScore += curr.getScore();
            totalScore += curr.getActualScore();
        }

        String actual = "";
        if (totalWeight > 0) {
            double actualScore = totalScore / totalWeight;
            actual = (actualScore * 100) + "%";
        } else {
            actual = "0%";
        }

        return actual;
    }

    public static String setRemainingWeight(ArrayList<Task> tasks) {
        double totalWeight = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            totalWeight += curr.getWeight();
        }

        double remains = 1 - totalWeight;

        return remains + " remaining";
    }
}
