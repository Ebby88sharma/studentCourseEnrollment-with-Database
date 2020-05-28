package studentCourseManagementApp;
import java.sql.*;
import java.util.Scanner;

public class Student {
	private String fname;
	private String lname;
	private String gradeYear;
	private String StudentID;
	private String courses="";
	private int tuitionBalance;
	private static int costOfCourse=600;
	private static int id=1000;
	private static int studentid = 1;
	// constructor : Prompt user to enter student's name and year
	public Student() {
		System.out.println("Enter First name");
		Scanner in=new Scanner(System.in);
				this.fname=in.nextLine();
				System.out.println("Enter last name");
				this.lname=in.nextLine();
				System.out.println("1: First year\n2: Second year\n3: Third year\n4: Final year\nEnter Student level ");
					this.gradeYear=in.nextLine();
					setStudentId();
					//System.out.println(fname+"  "+lname+"  "+gradeYear+" "+StudentID);
					
	}
   
	
   // Generate an ID
   private void setStudentId() {
	   id++;
	   //Grade leve+ ID
	   this.StudentID= gradeYear+""+ id;
   }
	//Enroll in course
   public void enroll() {
	   //Get inside a loop , when user hits Q
	   do {
	   System.out.println("Enter course to enroll(Q to quit):");
	   Scanner in=new Scanner(System.in);
	   String course=in.nextLine();
	   if(!course.equals("Q")) {	
		   courses = courses + "\n" + course;
		   tuitionBalance = tuitionBalance + costOfCourse;
	   }
	   else {
		   
		   break;
	   }
	   }while(1!=0);
	   //System.out.println("Enrolled in :"+courses);
	   
   }
	//view balance
   public void viewBalance() {
	   System.out.println("Your balance is: $"+tuitionBalance);
   }
	//pay tuition 
   public void payTuition() {
	   viewBalance();
	   System.out.println("Enter your payment: $");
	   Scanner in = new Scanner(System.in);
	   int payment = in.nextInt();
	   tuitionBalance = tuitionBalance - payment;
	   System.out.println("Thankyou for your payment of $"+payment);
	   viewBalance();
   }
	//Show status
   public String toString() {
	   return "Name: " + fname + " " + lname +
			   "\nGrade Level:" + gradeYear +
			   "\nStudent ID:" + StudentID +
			   "\nCourses Enrolled:" + courses + 
			   "\nBalance: $" + tuitionBalance;
   }
   // LOAD DATABESE
   public void mysqlLoad() throws Exception{
	   System.out.println("1");
	   String URL= "jdbc:mysql://localhost:3306/studentenrollApp";
	   String uname="root";
	   String password="@abhinav33522";
	   String query="insert into studentdataa values(?,?,?,?,?,?,?)";
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con = DriverManager.getConnection(URL,uname,password);
	   
	   PreparedStatement stmt = con.prepareStatement(query);
	   
	   stmt.setInt(1, studentid);
	   stmt.setString(2, fname);
	   stmt.setString(3, lname);
	   stmt.setString(4, gradeYear);
	   stmt.setString(5, StudentID);
	   stmt.setString(6, courses);
	   stmt.setInt(7, tuitionBalance);
	   
	   int count=stmt.executeUpdate();
        
	   System.out.println(count + " row/s affected");
	   studentid++;
	   
	   stmt.close();
	   con.close();
   }
}
