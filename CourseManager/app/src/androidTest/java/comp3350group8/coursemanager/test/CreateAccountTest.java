package comp3350group8.coursemanager.test;

import comp3350group8.coursemanager.Presentation.MainScreen;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class CreateAccountTest extends ActivityInstrumentationTestCase2<MainScreen> {
  	private Solo solo;
  	
  	public CreateAccountTest() {
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
        //Set default small timeout to 25071 milliseconds
		Timeout.setSmallTimeout(25071);
        //Enter the text: 'John'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.name));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.name), "John");
        //Enter the text: '777'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum), "777");
        //Enter the text: 'john12'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress), "john12");
        //Enter the text: 'umanitoba'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.school));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.school), "umanitoba");
        //Enter the text: 'car'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.password));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.password), "car");
        //Click on Create Account
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
	}
}
