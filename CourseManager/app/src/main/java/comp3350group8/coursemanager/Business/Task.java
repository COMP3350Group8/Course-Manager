package comp3350group8.coursemanager.Business;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Graham on 3/14/2016.
 */
public class Task extends ListItem {

    private String name, course;
    private String dueDate;
    private String dueTime;

    public Task() {         //null constructor
        this.name = null;
        this.course = null;
        this.dueDate = null;
        this.dueTime = null;
    }

    public Task(String name, String dueDate, String dueTime){
        this.name = name;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        //this.course = course.getName();
    }

    public boolean equals(ListItem otherItem) {
        boolean equal = false;

        if (otherItem instanceof Task) {
            Task other = (Task)otherItem;
            equal = other.course.equals(course);
        }

        return equal;
    }
    public String getTaskName() {return name;}
    public String getDate() {return dueDate;}
    public String getTime() {return dueTime;}
    //public String getTaskCourse() {return name;}
    public String toString() {
        return "Task: " + name + " Course: " + course + " Due Date: " + dueDate + " Due Time: " + dueTime;
    }
}
