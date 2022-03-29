import java.sql.*;
import java.util.Scanner;

public class StudentView {

	// To display information required by user
	public void display(int choice) {
		// Create a new object model and new object controller
		StudentModel studentModel = new StudentModel();
		StudentController studentController = new StudentController(studentModel, this);
		// To receive input
		Scanner input = new Scanner(System.in);
		
		// Decide action done based on choice
		if (choice == 1) {
			try {
				// Reading data from user
				System.out.println("Please enter the data.");
				System.out.print("Please enter the student's id: ");
				int id = input.nextInt();
				
				System.out.print("Please enter the student's name: ");
				String name = input.next();
				
				input.nextLine();
				System.out.print("Please enter the student's department: ");
				String department = input.nextLine();
				
				System.out.print("Please enter the student's mark for Mathematic: ");
				double mathMark = input.nextDouble();
				
				System.out.print("Please enter the student's mark for Science: ");
				double scienceMark = input.nextDouble();
				
				// Inserting the data through controller
				studentController.newStudent(id, name, department, mathMark, scienceMark);
			}catch (SQLException e) {
				e.printStackTrace();				
			}
		}else if (choice == 2) {
			// Reading student's id from user
			System.out.print("Please enter the student's id: ");
			int id = input.nextInt();
			try {
				// Reading data from database through controller
				studentController.getStudent(id);
			}catch (SQLException e) {
				e.printStackTrace();				
			}
		}
	}
	
	// To display information required by controller
	public void display (int id, String name, String department, double mathMark, double scienceMark) {
		System.out.println("Student's Details: ");
		System.out.println("Student's id: " + id);
		System.out.println("Student's name: " + name);
		System.out.println("Student's department: " + department);
		System.out.println("Mathematic Mark: " + mathMark);
		System.out.println("Science Mark: " + scienceMark);
	}
	
	
}
