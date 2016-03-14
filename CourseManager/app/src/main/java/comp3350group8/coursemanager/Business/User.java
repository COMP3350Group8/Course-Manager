package comp3350group8.coursemanager.Business;

/**
 * Created by David on 2016-03-12.
 */
<<<<<<< HEAD:CourseManager/app/src/main/java/comp3350group8/coursemanager/Business/User.java
public class User extends ListItem {
    private String name, password, email, school;
    private int studentNum;
=======
public class User {
    private String name, password, email, school, studentNum;
>>>>>>> master:CourseManager/app/src/main/java/comp3350group8/coursemanager/User.java

    public User(String name, String password, String studentNum, String email, String school)
    {
        this.name= name;
        this.password= password;
        this.studentNum = studentNum;
        this.email= email;
        this.school = school;
    }

    public String getPassWord() { return password;}

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    public String getStudentNum()
    {
        return studentNum;
    }

    public String getSchool()
    {
        return school;
    }

    public String toString() {
        return "Name: " + name;
    }

    public boolean equals(ListItem otherItem) {
        if (otherItem instanceof User) {
            User other = (User)otherItem;
            return other.name.equals(name) && other.studentNum == studentNum && other.email.equals(email);
        }
        return false;
    }
}
