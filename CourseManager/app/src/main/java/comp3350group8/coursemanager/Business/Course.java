package comp3350group8.coursemanager.Business;

import android.util.Log;

/**
 * Created by David on 2016-02-22.
 */
public class Course extends ListItem
{
    private String course;
    private String location;
    private String description;
    private String date;
    private int creditHours;
    private LetterGrade grade;
    private boolean finished;

    public Course(String course, String location, String description, String date, int credits) {
        this.course= getString(course);
        this.location= location;
        this.description = description;
        creditHours = credits;
        grade = new LetterGrade();
        finished = false;
        this.date = date;
    }

    public boolean equals(ListItem otherItem) {
        boolean equal = false;

        if (otherItem instanceof Course) {
            Course other = (Course)otherItem;
            equal = other.course.equals(course) && other.location.equals(location) && other.description.equals(description) && other.creditHours == creditHours;
        }

        return equal;
    }

    public String getName() {return course; }

    public void setName(String name) {
        course = name;
    }

    public String getLocation() {return location;}
    public String getDescription() {return description;}
    public String getDate() {return date;}
    public int getCreditHours() {return creditHours; }

    public void setGrade(LetterGrade g) {
        Log.d("DEBUG", "setGrade(" + g.toString() + ")");
        grade = g;

        if (!g.isDefault()) {
            Log.d("DEBUG", "g = " + g);
            finished = true;
        }
    }

    public boolean isFinished() {return finished;}

    public LetterGrade getGrade() {return grade;}

    public String toString() {
        String output = "Course Name: " + course
                + "\nLocation: " + location
                + "\nDescription: " + description
                + "\nDate: " + date
                + "\nCredit Hours: " + creditHours;

        if (!grade.isDefault()) {
            Log.d("Grade", "GRade = " + grade);
            Log.d("Grade", "Default = " + LetterGrade.getDefaultMessage());
            output = output + "\n" + grade.toString();
        }

        return output;
    }
}