package comp3350group8.coursemanager.BusinessTests;

import android.util.Log;

import junit.framework.TestCase;

import comp3350group8.coursemanager.Business.LetterGrade;

/**
 * Created by Ian Smith on 2016-04-01.
 */
public class LetterGradeTest extends TestCase {
    public void testLetterGrades() {
        String[] grade = {"A", "A+", "F", "", "BREABAETNBASRHA"};
        LetterGrade[] actualGrades = new LetterGrade[grade.length];

        for (int i = 0; i < grade.length; i++) {
            actualGrades[i] = new LetterGrade(grade[i]);
            Log.d("DEBUG", "actualGrades[" + i + "] = " + actualGrades[i]);
        }

        assertTrue(actualGrades[3].equals(actualGrades[4]));
        assertTrue(actualGrades[2].equals(actualGrades[3]));
        assertFalse(actualGrades[0].equals(actualGrades[1]));
    }
}
