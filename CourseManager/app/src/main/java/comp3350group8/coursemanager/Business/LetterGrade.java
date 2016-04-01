package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-04-01.
 */
public class LetterGrade {
    private double points;
    private String grade;

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
        this.grade = grade;
        boolean stop = false;
        for (int i = 0; i < possibilities.length && !stop; i++) {
            if (equals(possibilities[i])) {
                stop = true;
                this.points = possibilities[i].points;
                this.grade = possibilities[i].grade;
            }
        }

        if (!stop) {
            points = 0;
            this.grade = "F";
        }
    }

    private LetterGrade(String grade, double points) {
        this.grade = grade;
        this.points = points;
    }

    public LetterGrade() {
        grade = "";
    }

    public boolean equals(LetterGrade other) {
        boolean equals = false;

        if (other.grade.equals(grade)) {
            equals = true;
        }

        return equals;
    }

    public String getGrade() {return grade;}
    public double getPoints() {return points;}

    public String toString() {
        return "Grade = " + grade
                + "\nPoints = " + points;
    }
}

