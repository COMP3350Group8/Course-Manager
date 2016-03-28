package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-03-14.
 */
public class CurrentCourse {
    private static String coursename = "";
    private static long id = -1;

    public static void setCourse(String course) { coursename = course; }
    public static String getCourseName() {return coursename;}

    public static void setID(long ID) {id = ID;}
    public static long getID() {return id;}

    public static void reset() {coursename = null; id=-1;}
}
