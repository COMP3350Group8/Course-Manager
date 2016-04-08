package comp3350group8.coursemanager.Business;

import java.util.ArrayList;

/**
 * Created by Ian Smith on 2016-04-08.
 */
public class GPACalculator {
    private static ArrayList<Course> courseList;

    public static void init(ArrayList<Course> list) {
        courseList = list;
    }

    public static double getGPA() {
        double totalPoints = 0;
        double totalCredits = 0;
        double result = 0;
        
        for (int i = 0; i < courseList.size(); i++) {
            Course curr = courseList.get(i);

            if (curr.isFinished()) {
                totalPoints += curr.getGrade().getPoints();
                totalCredits += curr.getCreditHours();
            }
        }

        if (totalCredits > 0) {
            result = totalPoints / totalCredits;
        }

        return result;
    }
}
