package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-03-14.
 */
public class CurrentCourse {
    private static String coursename;

    public static void setCourse(String course) { coursename = course; }

    public static String getCourseName() {return coursename;}
}
