package comp3350group8.coursemanager.Business;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Graham on 3/14/2016.
 */
public class Task extends ListItem {
    private String name;
    private String dueDate;
    private String dueTime;
    private double weight;
    private double score;

    public Task() {         //null constructor
        this.name = null;
        this.dueDate = null;
        this.dueTime = null;
        this.weight = 0.0;
        this.score = 0.0;
    }

    public Task(String name, String dueDate, String dueTime, double weight){
        if (weight <= 1) {
            this.name = getString(name);
            this.dueTime = dueTime;
            this.dueDate = dueDate;
            this.weight = weight;
            this.score = 0.0;
        }
    }

    public boolean equals(ListItem otherItem) {
        boolean equal = false;

        if (otherItem instanceof Task) {
            Task other = (Task)otherItem;
            equal = other.name.equals(name);
        }

        return equal;
    }

    public String getName() {return name;}
    public String getDate() {return dueDate;}
    public String getTime() {return dueTime;}
    public double getWeight() {return weight;}
    public double getScore() {return score;}
    public double getActualScore(){return score * weight;}

    public void setScore(double score) {this.score = score;}
   // public String getTaskCourse() {return name;}

    public String toString() {
        return "Task: " + name
                + "\nDue Date: " + dueDate
                + "\nDue Time: " + dueTime
                + "\nWeight= " + weight
                + "\nScore = " + score;
    }
}
