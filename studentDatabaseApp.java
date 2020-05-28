package studentCourseManagementApp;

import java.util.Scanner;

public class studentDatabaseApp {

	public static void main(String[] args) throws Exception {
		
		//Ask how many users we need to add
		
		System.out.println("Enter number of students to enrol:-");
		Scanner in=new Scanner(System.in);
		int numofStudents=in.nextInt();
		Student [] students=new Student[numofStudents];
		
		//Create n number of new students
        for(int n=0 ; n < numofStudents ; n++) {
        	students[n]=new Student();
        	students[n].enroll();
        	students[n].payTuition();
        	students[n].mysqlLoad();
    		System.out.println(students[n].toString());
        }
	}

}
