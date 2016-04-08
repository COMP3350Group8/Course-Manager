package comp3350group8.coursemanager.Business;

/**
 * Created by David on 2016-03-12.
 */
public class User extends ListItem {
    private String name, password, email, school;
    private String studentNum;
    private double gpa;

    public User(String name, String password, String studentNum, String email, String school)
    {
        this.name= name;
        this.password= password;
        this.studentNum = getString(studentNum);
        this.email= getString(email);
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
    public double getGPA() {return gpa;}

    public void setGPA(double g) {gpa = g;}

    public boolean equals(ListItem otherItem) {
        if (otherItem instanceof User) {
            User other = (User)otherItem;
            return other.name.equals(name) && other.studentNum .equals (studentNum) && other.email.equals(email);
        }
        return false;
    }

    public String toString() {
        String toString = "Name: " + name
                + "\nEmail Address/Username: " + email
                + "\nSchool: " + school
                + "\nStudent Number:" + studentNum;

        if (gpa > 0) {
            toString = toString + "\nGPA: " + gpa;
        }

        return toString;
    }
}
