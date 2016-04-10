package comp3350group8.coursemanager.BusinessTests;

import android.util.Log;

import junit.framework.TestCase;

import comp3350group8.coursemanager.Business.RoundNumber;

/**
 * Created by Ian Smith on 2016-04-10.
 */
public class RoundNumberTest extends TestCase {
    public void testRoundNumbers() {
        double [] array = {1.51674, 2.45176, 3.7834921, 4, 5};
        int [] params = {100, 1000, 10, 100000, 1};

        for (int i = 0; i < array.length; i++) {
            RoundNumber number = new RoundNumber(array[i]);
            assertNotNull(number);
            Log.d("DEBUG", "Rounded version of " + array[i] + " is " + number.roundTo(params[i % params.length]));
        }
    }
}
