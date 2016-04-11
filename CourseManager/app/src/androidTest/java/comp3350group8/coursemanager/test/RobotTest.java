package comp3350group8.coursemanager.test;

import comp3350group8.coursemanager.Presentation.MainScreen;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class RobotTest extends ActivityInstrumentationTestCase2<MainScreen> {
  	private Solo solo;
  	
  	public RobotTest() {
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
        //Set default small timeout to 46308 milliseconds
		Timeout.setSmallTimeout(46308);
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.name));
        //Enter the text: 'Ian'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.name));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.name), "Ian");
        //Enter the text: '765'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum), "765");
        //Enter the text: 'smithi35'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress), "smithi35");
        //Enter the text: 'umanitoba'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.school));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.school), "umanitoba");
        //Click on 765
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.studentNum));
        //Enter the text: '767'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum), "767");
        //Click on smithi35
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.emailAddress));
        //Enter the text: 'smithi37'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress), "smithi37");
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
        //Enter the text: 'None'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.location));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.location), "None");
        //Enter the text: 'None'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.description));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.description), "None");
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits), "3");
        //Click on M W F
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.checkBoxMWF));
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
        //Click on Save Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button4));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on COMP 1010 None None
		solo.clickInList(1, 0);
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Assert that: '1.0 remaining' is shown
		assertTrue("'1.0 remaining' is not shown!", solo.waitForView(solo.getView(comp3350group8.coursemanager.R.id.Remaining)));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Exam'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Exam");
        //Enter the text: '1'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "1");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Exam
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '1'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "1");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add Grade
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
        //Click on COMP 1020
		solo.clickInList(2, 0);
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'a1'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "a1");
        //Enter the text: '0.2'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "0.2");
        //Click on 00:00
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.timeBtn));
        //Click on Cancel
		solo.clickOnView(solo.getView(android.R.id.button2));
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'a2'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "a2");
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.weight));
        //Enter the text: '0.3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "0.3");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'exam'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "exam");
        //Enter the text: '0.5'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "0.5");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on a1
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '0.3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "0.3");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on a2
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Enter the text: 'a2'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "a2");
        //Enter the text: '0.7'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "0.7");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on exam
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '0.7'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "0.7");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddGrade'
		assertTrue("comp3350group8.coursemanager.Presentation.AddGrade is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddGrade.class));
        //Enter the text: 'C'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade), "C");
        //Click on Add Course Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGradeButton));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Course List
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.CourseList));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on COMP 2140
		solo.clickInList(3, 0);
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Midterm'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Midterm");
        //Enter the text: '0.5'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "0.5");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Exam'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Exam");
        //Enter the text: '0.5'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "0.5");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Exam
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '0.6'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "0.6");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Exam
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Press menu back key
		solo.goBack();
        //Click on Midterm
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '0.8'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "0.8");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddGrade'
		assertTrue("comp3350group8.coursemanager.Presentation.AddGrade is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddGrade.class));
        //Enter the text: 'B'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade), "B");
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
	}
}
