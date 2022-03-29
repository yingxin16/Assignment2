import java.sql.*;

public class StudentController {

	private StudentModel model;
	private StudentView view;


	public StudentController(StudentModel model, StudentView view) {
		this.model = model;
		this.view = view;
	}

	// Read data of student from user and save it into database
	public void newStudent(int id, String name, String department, double mathMark, double scienceMark) throws SQLException{
		// Create an object for model class
		//StudentModel studentModel = new StudentModel();
		// Establishing connection and create statement
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?", "root", "987654321");
		Statement stmt = conn.createStatement();

		// Inserting data into database
		stmt.executeUpdate("INSERT INTO STUDENT VALUES (" + id + ", '" + name + "', '" + department + "', " + mathMark + ", " + scienceMark + ");");

		// Send a notification
		System.out.println("Data has been input into database.");
	}
	
	// Read student's id from user and retrieve data from database
	public void getStudent(int id)throws SQLException{
		// Create an object for model class
		StudentModel studentModel = new StudentModel();
		
		// Establishing connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?", "root", "987654321");
		
		// Searching for specific student from the database
		String mySQL = "SELECT * FROM STUDENT WHERE ID = " + id;
		
		// Execute the statement
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(mySQL);
		
		if(rs.next()) {
			studentModel.setId(rs.getInt("id"));
			studentModel.setName(rs.getString("name"));
			studentModel.setDepartment(rs.getString("department"));
			studentModel.setMathMark(rs.getDouble("mathMark"));
			studentModel.setScienceMark(rs.getDouble("scienceMark"));
		}
		
		// Passing the data to view to be displayed to the user
		view.display(studentModel.getId(), studentModel.getName(), studentModel.getDepartment(), studentModel.getMathMark(), studentModel.getScienceMark());
		
		
	}

}
