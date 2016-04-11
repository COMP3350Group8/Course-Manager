package comp3350group8.coursemanager.test;

import comp3350group8.coursemanager.Presentation.MainScreen;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class RobotiumTest extends ActivityInstrumentationTestCase2<MainScreen> {
  	private Solo solo;
  	
  	public RobotiumTest() {
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
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.name));
        //Enter the text: 'John Doe'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.name));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.name), "John Doe");
        //Enter the text: '123'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.studentNum), "123");
        //Enter the text: 'Doej123'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.emailAddress), "Doej123");
        //Enter the text: 'umanitoba'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.school));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.school), "umanitoba");
        //Enter the text: 'car'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.password));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.password), "car");
        //Set default small timeout to 16952 milliseconds
		Timeout.setSmallTimeout(16952);
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
        //Enter the text: 'E2-105'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.location));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.location), "E2-105");
        //Enter the text: 'Intro to CS'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.description));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.description), "Intro to CS");
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits), "3");
        //Click on comp3350group8.coursemanager.R.id.chkBoxM
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxM));
        //Click on comp3350group8.coursemanager.R.id.chkBoxW
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxW));
        //Click on comp3350group8.coursemanager.R.id.chkBoxF
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxF));
        //Click on 00:00
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.timeBtn));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on Save Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button4));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on Add New Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button3));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddCourse'
		assertTrue("comp3350group8.coursemanager.Presentation.AddCourse is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddCourse.class));
        //Enter the text: 'COMP 1010'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName), "COMP 1010");
        //Enter the text: 'E2-229'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.location));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.location), "E2-229");
        //Enter the text: 'Intro to CS'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.description));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.description), "Intro to CS");
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits), "3");
        //Click on comp3350group8.coursemanager.R.id.chkBoxT
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxT));
        //Click on Th
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxTh));
        //Click on 00:00
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.timeBtn));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on Save Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button4));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on Add New Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button3));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddCourse'
		assertTrue("comp3350group8.coursemanager.Presentation.AddCourse is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddCourse.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.courseName));
        //Enter the text: 'COMP 2140'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName), "COMP 2140");
        //Enter the text: 'E2-320'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.location));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.location), "E2-320");
        //Enter the text: 'Data Structures'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.description));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.description), "Data Structures");
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits), "3");
        //Click on comp3350group8.coursemanager.R.id.chkBoxM
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxM));
        //Click on comp3350group8.coursemanager.R.id.chkBoxW
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxW));
        //Click on comp3350group8.coursemanager.R.id.chkBoxF
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxF));
        //Click on 00:00
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.timeBtn));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on Save Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button4));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on COMP 1010
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Ass1'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Ass1");
        //Enter the text: '5'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "5");
        //Click on 00:00
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.timeBtn));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on 00/00/0000
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.dateBtn));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
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
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "3");
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Ass1
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Ass2'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Ass2");
        //Enter the text: '5'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "5");
        //Click on 00:00
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.timeBtn));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on 00/00/0000
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.dateBtn));
        //Click on SimpleMonthView
//		solo.clickOnView(solo.getView(android.widget.SimpleMonthView.class, 0));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Ass2
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '3.5'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "3.5");
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Ass2
		solo.clickOnView(solo.getView(android.R.id.text1, 1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskName));
        //Enter the text: 'Midterm'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Midterm");
        //Enter the text: '20'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "20");
        //Click on 00:00
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.timeBtn));
        //Click on Cancel
		solo.clickOnView(solo.getView(android.R.id.button2));
        //Click on Cancel
		solo.clickOnView(solo.getView(android.R.id.button2));
        //Click on 00/00/0000
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.dateBtn));
		//Robotium doesn't seem to like SimpleMonthView
        //Click on SimpleMonthView
//		solo.clickOnView(solo.getView(android.widget.SimpleMonthView.class, 0));
        //Click on SimpleMonthView
//		solo.clickOnView(solo.getView(android.widget.SimpleMonthView.class, 0));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Midterm
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '19'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "19");
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Exam'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Exam");
        //Enter the text: '70'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "70");
        //Click on 00/00/0000
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.dateBtn));
        //Click on SimpleMonthView
//		solo.clickOnView(solo.getView(android.widget.SimpleMonthView.class, 0));
        //Click on Ok
		solo.clickOnView(solo.getView(android.R.id.button1));
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Exam
		solo.clickOnView(solo.getView(android.R.id.text1, 2));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on 00:00
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskDueTime));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '60'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "60");
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add Final Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddGrade'
		assertTrue("comp3350group8.coursemanager.Presentation.AddGrade is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddGrade.class));
        //Enter the text: 'A'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade), "A");
        //Click on Add Course Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGradeButton));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add Final Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddGrade'
		assertTrue("comp3350group8.coursemanager.Presentation.AddGrade is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddGrade.class));
        //Click on Add Course Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGradeButton));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Course List
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.CourseList));
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
        //Enter the text: '1000'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "1000");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Click on 1000
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.weight));
        //Enter the text: '100'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "100");
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
        //Enter the text: '60'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "60");
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add Final Grade
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
        //Click on Add Final Grade
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddGrade'
		assertTrue("comp3350group8.coursemanager.Presentation.AddGrade is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddGrade.class));
        //Enter the text: 'D'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.AddGrade), "D");
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
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.etuserName));
        //Enter the text: 'Doef123'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etuserName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etuserName), "Doef123");
        //Enter the text: 'car'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etPassword));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etPassword), "car");
        //Click on Login
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.bLogin));
        //Click on Doef123
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.etuserName));
        //Enter the text: 'Doej123'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etuserName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.etuserName), "Doej123");
        //Click on Login
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.bLogin));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on Add New Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button3));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddCourse'
		assertTrue("comp3350group8.coursemanager.Presentation.AddCourse is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddCourse.class));
        //Set default small timeout to 17748 milliseconds
		Timeout.setSmallTimeout(17748);
        //Enter the text: 'COMP 2150'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.courseName), "COMP 2150");
        //Enter the text: '3'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.credits), "3");
        //Click on comp3350group8.coursemanager.R.id.chkBoxT
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxT));
        //Click on Th
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.chkBoxTh));
        //Click on Save Course
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.button4));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.ListOfCourses'
		assertTrue("comp3350group8.coursemanager.Presentation.ListOfCourses is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.ListOfCourses.class));
        //Click on COMP 2150
		solo.clickOnView(solo.getView(android.R.id.text1, 3));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Midterm'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Midterm");
        //Enter the text: '50'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "50");
        //Click on Save Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.saveTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Midterm
		solo.clickOnView(solo.getView(android.R.id.text1));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskDetail'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskDetail is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskDetail.class));
        //Click on Empty Text View
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.taskScore));
        //Enter the text: '40'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "40");
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.TaskList'
		assertTrue("comp3350group8.coursemanager.Presentation.TaskList is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.TaskList.class));
        //Click on Add new Task
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.AddTask));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.AddTask'
		assertTrue("comp3350group8.coursemanager.Presentation.AddTask is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.AddTask.class));
        //Enter the text: 'Exam'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskName), "Exam");
        //Enter the text: '50'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.weight), "50");
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
        //Enter the text: '35'
		solo.clearEditText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore));
		solo.enterText((android.widget.EditText) solo.getView(comp3350group8.coursemanager.R.id.taskScore), "35");
        //Click on Save Changes
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.SaveTaskDetail));
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
        //Set default small timeout to 26781 milliseconds
		Timeout.setSmallTimeout(26781);
        //Click on Log Out
		solo.clickOnView(solo.getView(comp3350group8.coursemanager.R.id.logout));
        //Wait for activity: 'comp3350group8.coursemanager.Presentation.LoginActivity'
		assertTrue("comp3350group8.coursemanager.Presentation.LoginActivity is not found!", solo.waitForActivity(comp3350group8.coursemanager.Presentation.LoginActivity.class));
	}
}
