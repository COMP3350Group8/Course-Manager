package comp3350group8.coursemanager.Business;

/**
 * Created by David on 2016-02-22.
 */
public class Course extends ListItem
{
    private int _ID = 0;
    private String course;
    private String location;
    private String description;

    public Course(String course, String location, String description)
    {
        this.course= course;
        this.location= location;
        this.description = description;
    }

    public boolean equals(ListItem otherItem) {
        boolean equal = false;

        if (otherItem instanceof Course) {
            Course other = (Course)otherItem;
            equal = other._ID == _ID && other.course.equals(course) && other.location.equals(location) && other.description.equals(description);
        }

        return equal;
    }

    public void setID(int id) {_ID = id;}
    public int getID() {return _ID;}

    public String getName() {
        return course;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "Name: " + course + ", Location: " + location + ", Description: " + description;
    }
}
