package comp3350group8.coursemanager.Business;

/**
 * Created by David on 2016-03-12.
 */
public class User {
    private String name, password, email, school;
    private int studentNum;

    public User(String name, String password, int studentNum, String email, String school)
    {
        this.name= name;
        this.password= password;
        this.studentNum = studentNum;
        this.email= email;
        this.school = school;
    }

    public String getPassWord()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    public int getStudentNum()
    {
        return studentNum;
    }

    public String getSchool()
    {
        return school;
    }
}
