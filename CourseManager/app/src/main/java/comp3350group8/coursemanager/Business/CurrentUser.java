package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-03-14.
 */
public class CurrentUser {
    private static String username = "";

    public static void setUser(String user) { username = user; }

    public static String getUser() {return username;}

    public static void reset() { username = "";}
}
