package comp3350group8.coursemanager.Business;

import android.util.Log;

/**
 * Created by Ian Smith on 2016-04-01.
 */
public class LetterGrade {
    private double points;
    private String grade;
    private static String defaultMessage = "Not calculated yet";

    private static LetterGrade[] possibilities = {
            new LetterGrade("A+", 13.5),
            new LetterGrade("A", 12),
            new LetterGrade("B+", 10.5),
            new LetterGrade("B", 9),
            new LetterGrade("C+", 7.5),
            new LetterGrade("C", 6),
            new LetterGrade("D", 3),
            new LetterGrade("F", 0)};

    public LetterGrade(String grade) {
        if (grade != null) {
            Log.d("LetterGrade", "Grade = " + grade + ", length = " + grade.length());

            if (grade.length() == 1 || grade.length() == 2) {
                boolean stop = false;
                for (int i = 0; i < possibilities.length && !stop; i++) {
                    if (stringEquals(grade, possibilities[i])) {
                        stop = true;
                        this.points = possibilities[i].points;
                        this.grade = possibilities[i].grade;
                    }
                }

                Log.d("LetterGrade", "grade = " + this.grade);
            } else {
                this.grade = defaultMessage;
            }
        } else {
            this.grade = defaultMessage;
            //points = 0;
        }
    }

    private LetterGrade(String grade, double points) {
        this.grade = grade;
        this.points = points;
    }

    public LetterGrade() {
        grade = defaultMessage;
    }

    public boolean equals(LetterGrade other) {
        boolean equals = false;

        if (other.grade.equals(grade)) {
            equals = true;
        }

        return equals;
    }

    private boolean stringEquals(String g, LetterGrade other) {
        boolean equal = false;

        if (g.equals(other.grade)) {
            equal = true;
        }

        return equal;
    }

    public String getGrade() {return grade;}
    public double getPoints() {return points;}
    public static String getDefaultMessage() {return defaultMessage;}
    public boolean isDefault() {return grade.equals(defaultMessage);}

    public String toString() {
        return "Grade = " + grade
                + "\nPoints = " + points;
    }
}

