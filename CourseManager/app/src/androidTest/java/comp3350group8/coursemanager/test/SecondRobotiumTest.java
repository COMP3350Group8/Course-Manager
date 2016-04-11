package comp3350group8.coursemanager.test;

import comp3350group8.coursemanager.Presentation.MainScreen;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class SecondRobotiumTest extends ActivityInstrumentationTestCase2<MainScreen> {
  	private Solo solo;
  	
  	public SecondRobotiumTest() {
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
        //Enter the text: 'Jane Doe'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.name));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.name), "Jane Doe");
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.studentNum));
        //Enter the text: '1'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum), "1");
        //Enter the text: 'jdoe'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress), "jdoe");
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
        //Click on Add New Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button3));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddCourse'
		assertTrue("comp3350group8.coursemanager.Presentation.AddCourse is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddCourse.class));
        //Enter the text: 'COMP 1010'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName), "COMP 1010");
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits), "3");
        //Click on comp3350group8.coursemanager.R.id.chkBoxM
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxM));
        //Click on Save Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button4));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on Add New Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button3));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddCourse'
		assertTrue("comp3350group8.coursemanager.Presentation.AddCourse is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddCourse.class));
        //Enter the text: 'COMP 1020'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName), "COMP 1020");
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits), "3");
        //Click on comp3350group8.coursemanager.R.id.chkBoxW
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxW));
        //Click on Save Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button4));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on Add New Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button3));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddCourse'
		assertTrue("comp3350group8.coursemanager.Presentation.AddCourse is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddCourse.class));
        //Enter the text: 'COMP 2140'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName), "COMP 2140");
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits), "3");
        //Click on comp3350group8.coursemanager.R.id.chkBoxF
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxF));
        //Click on Save Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button4));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on COMP 2140
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Exam'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Exam");
        //Enter the text: '100'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "100");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add Final Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddGrade'
		assertTrue("comp3350group8.coursemanager.Presentation.AddGrade is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddGrade.class));
        //Enter the text: 'B+'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade), "B+");
        //Click on Add Course Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGradeButton));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Course List
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.CourseList));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on COMP 1020
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Ass1'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Ass1");
        //Enter the text: '100'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "100");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Ass1
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '95'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "95");
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add Final Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddGrade'
		assertTrue("comp3350group8.coursemanager.Presentation.AddGrade is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddGrade.class));
        //Enter the text: 'A+'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade), "A+");
        //Click on Add Course Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGradeButton));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Course List
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.CourseList));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on Log Out
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.logout));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.LoginActivity'
		assertTrue("comp3350group8.coursemanager.Presentation.LoginActivity is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.LoginActivity.class));
        //Enter the text: 'jdoe'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etuserName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etuserName), "jdoe");
        //Enter the text: 'car'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etPassword));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etPassword), "car");
        //Click on Login
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.bLogin));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
	}
}
