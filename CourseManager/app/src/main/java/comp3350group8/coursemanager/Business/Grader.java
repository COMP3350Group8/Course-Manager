package comp3350group8.coursemanager.Business;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ian Smith on 2016-03-25.
 */
public class Grader {
    private static double remainingWeight = 1;

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
            RoundNumber score = new RoundNumber(actualScore);
            actualScore = score.roundTo(10000);
            actual = (actualScore * 100) + "%";
        } else {
            actual = "0%";
        }

        return actual;
    }

    public static double setRemainingWeight(ArrayList<Task> tasks) {
        double totalWeight = 0;

        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            totalWeight += curr.getWeight();
        }

        double remains = 1.0 - totalWeight;
        Log.d("DEBUG", "remains = " + remains);

        RoundNumber round = new RoundNumber(remains);
        remains = round.roundTo(1000);
        Log.d("DEBUG", "round = " + round);

        return remains;
    }

    public static double getRemainingWeight() {return remainingWeight;}

    public static double calculateScore(double score, double weight) {
        double calculated = score * weight * 100;
        RoundNumber rounderNumber = new RoundNumber(calculated);
        calculated = rounderNumber.roundTo(10);

        return calculated;
    }

    public static double calculatePercentageScore(double score, double weight) {
        double percent = score / weight;
        RoundNumber rounderNumber = new RoundNumber(percent);
        percent = rounderNumber.roundTo(10000);

        return percent;
    }
}
