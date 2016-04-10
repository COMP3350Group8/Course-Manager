package comp3350group8.coursemanager.test;

import comp3350group8.coursemanager.Presentation.MainScreen;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class LoginTest extends ActivityInstrumentationTestCase2<MainScreen> {
  	private Solo solo;
  	
  	public LoginTest() {
		super(MainScreen.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.MainScreen'
		solo.waitForActivity(comp3350group8.coursemanager.Presentation.MainScreen.class, 2000);
        //Click on Sign In
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button2));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.LoginActivity'
		assertTrue("comp3350group8.coursemanager.Presentation.LoginActivity is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.LoginActivity.class));
        //Enter the text: 'john12'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etuserName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etuserName), "john12");
        //Enter the text: 'car'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etPassword));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etPassword), "car");
        //Click on Login
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.bLogin));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
	}
}
