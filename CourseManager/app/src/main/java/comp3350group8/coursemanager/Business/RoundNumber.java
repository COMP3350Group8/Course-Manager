package comp3350group8.coursemanager.Business;

/**
 * Created by Ian Smith on 2016-04-10.
 */
public class RoundNumber {
    private double number;

    public RoundNumber(double param) {
        number = param;
    }

    public double roundTo(int param) {
        double copy = number;
        copy = copy * param;
        copy = Math.round(copy);
        copy = copy / param;

        return copy;
    }
}
