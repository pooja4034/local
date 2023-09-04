class Course implements Cloneable
{
    String subject1;
    String subject2;
    String subject3;
    public Course(String sub1,String sub2,String sub3)
    {
        this.subject1 = sub1;
        this.subject2 = sub2;
        this.subject3 = sub3;
    }
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
class Student implements Cloneable{
    int id;
    String name;
    Course course;
    public Student(int id, String name, Course course)
    {
        this.id = id;
        this.name = name;
        this.course = course;
    }
    protected Object clone()throws CloneNotSupportedException
    {
        Student student = (Student) super.clone();
        student.course = (Course) course.clone();
        return student;
    }
}
public class DeepCopyInJava
{
    public static void main(String[] args) throws Exception
    {
    Course c1= new Course("physics","chem","bio");
    Student s1 = new Student(111,"john", c1);
    Student s2 = null;
    s2 = (Student) s1.clone();
    System.out.println(s1.course.subject3);
    s2.course.subject3 = "Maths";

    System.out.println("student 1:"+s1.course.subject3);
    System.out.println("Student 3:"+s2.course.subject3);
    }
}