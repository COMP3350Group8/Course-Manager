package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-03-21.
 */
public class CurrentTask {
    private static Task current = null;

    public static void setTask(Task c) {
        current = c;
    }

    public static Task getTask() {
        return current;
    }
}
