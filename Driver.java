package software;
/*   
Author: Chan In Kou
Purpose: It's a menu that provide ways to add students, faculty members, courses and save it in .csv or import from .csv.
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Driver {
	private List<Student> students = new ArrayList<Student>();
	private List<FacultyMember> facultyMembers = new ArrayList<FacultyMember>();
	private List<Course> courses = new ArrayList<Course>();
	private List<Course> copyCourse1 = new ArrayList<Course>();
	private List<Course> copyCourse2 = new ArrayList<Course>();
	private int remove;

	public static void main(String[] args) {
		Driver michael = new Driver();
		michael.main();
	}

	public void main() {
		String[] choices = { "Quit", "Students", "FacultyMembers", "Courses", "Save in csv", "Import from csv" };
		int choice;
		do {
			choice = JOptionPane.showOptionDialog(null, "University", "Main Menu", 0, JOptionPane.QUESTION_MESSAGE,
					null, choices, "null");

			switch (choice) {
			case 0:
				break;
			case 1:
				studentAddDeleteView();
				break;
			case 2:
				facultyAddDeleteView();
				break;
			case 3:
				courseAddDeleteView();
				break;
			case 4:
				saveListOfEverything();
				break;
			case 5:
				deleteAndImport();
				break;
			} // end switch
		} while (choice != 0); // end do
	}

	// option 1
	private void studentAddDeleteView() {
		String[] choices = { "Quit", "Add", "Delete", "View Student", "View Course Schedules", "Add Course",
				"Delete Course" };
		int choice;
		do {
			choice = JOptionPane.showOptionDialog(null, "Option", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null,
					choices, "null");
			switch (choice) {
			case 0:
				break;
			case 1:
				addStudent();
				break;
			case 2:
				if (!(students.isEmpty()))
					deleteStudent();
				break;
			case 3:
				if (!(students.isEmpty()))
					listOfStudent();
				break;
			case 4:
				if (!(copyCourse1.isEmpty()))
					showStudentSchedule();
				break;
			case 5:
				if (!(courses.isEmpty()))
					addStudentCourse();
				break;
			case 6:
				if (!(copyCourse1.isEmpty()))
					deleteStudentCourse();
				break;
			} // end switch
		} while (choice != 0); // end do
	}

	// asking the user for the student input
	private void addStudent() {
		int cin = Integer.parseInt(JOptionPane.showInputDialog("Please enter the CIN for the Student"));
		String name = JOptionPane.showInputDialog("Please enter the name of the Student");
		int streetNumber = Integer
				.parseInt(JOptionPane.showInputDialog("Please enter the street number of the Student"));
		String streetName = JOptionPane.showInputDialog("Please enter the street name of the Student");
		String city = JOptionPane.showInputDialog("Please enter the city name of the Student");
		String state = JOptionPane.showInputDialog("Please enter the state name of the Student");
		String country = JOptionPane.showInputDialog("Please enter the country name of the Student");
		students.add(new Student(cin, name, streetNumber, streetName, city, state, country));
	}

	// show the list of student
	private void listOfStudent() {
		JOptionPane.showMessageDialog(null, students);
	}

	// delete students
	private void deleteStudent() {
		JOptionPane.showMessageDialog(null, students);
		remove = Integer
				.parseInt(JOptionPane.showInputDialog("Please enter the CIN of the student that you want to remove"));
		for (int i = 0; i < students.size(); i++) {
			if (remove == (students.get(i).getCin())) {
				students.remove(i);
			}
		}
	}

	// show student schedule
	private void showStudentSchedule() {
		JOptionPane.showMessageDialog(null, copyCourse1);
	}

	// add courses for student (don't know how to add course for a student)
	private void addStudentCourse() {
		// show what courses is open
		JOptionPane.showMessageDialog(null, courses);
		String courseId = JOptionPane.showInputDialog("Please enter the course ID you want to add");
		String courseTitle = JOptionPane
				.showInputDialog("Please enter the course title of the course that you want to add");
		copyCourse1.add(new Course(courseId, courseTitle));
	}

	// delete course for student (don't know how to)
	private void deleteStudentCourse() {
		JOptionPane.showMessageDialog(null, copyCourse1);
		remove = Integer.parseInt(JOptionPane.showInputDialog("Please enter the course ID that you want to drop"));
	}

	// option 2
	private void facultyAddDeleteView() {
		String[] choices = { "Quit", "Add", "Delete", "View FacultyMember", "View teaching schedule", "Assign Course",
				"Delete Course" };
		int choice;
		do {
			choice = JOptionPane.showOptionDialog(null, "Option", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null,
					choices, "null");
			switch (choice) {
			case 0:
				break;
			case 1:
				addFacultyMember();
				break;
			case 2:
				if (!(facultyMembers.isEmpty()))
					deleteFacultyMember();
				break;
			case 3:
				if (!(facultyMembers.isEmpty()))
					listOfFacultyMember();
				break;
			case 4:
				if (!(copyCourse2.isEmpty()))
					showFacultySchedule();
				break;
			case 5:
				if (!(courses.isEmpty()))
					addFacultyCourse();
				break;
			case 6:
				if (!(copyCourse2.isEmpty()))
					deleteFacultyCourse();
				break;
			} // end switch
		} while (choice != 0); // end do
	}

	// asking for the user for input
	private void addFacultyMember() {
		int employeeId = Integer
				.parseInt(JOptionPane.showInputDialog("Please enter the employeeID of the Faculty Member"));
		String name = JOptionPane.showInputDialog("Please enter the name of the Faculty Member");
		int streetNumber = Integer
				.parseInt(JOptionPane.showInputDialog("Please enter the street number of the Student"));
		String streetName = JOptionPane.showInputDialog("Please enter the street name of the Student");
		String city = JOptionPane.showInputDialog("Please enter the city name of the Student");
		String state = JOptionPane.showInputDialog("Please enter the state name of the Student");
		String country = JOptionPane.showInputDialog("Please enter the country name of the Student");
		facultyMembers.add(new FacultyMember(employeeId, name, streetNumber, streetName, city, state, country));
	}

	// show the list of faculty members
	private void listOfFacultyMember() {
		JOptionPane.showMessageDialog(null, facultyMembers);
	}

	// delete facultyMembers
	private void deleteFacultyMember() {
		JOptionPane.showMessageDialog(null, facultyMembers);
		remove = Integer.parseInt(JOptionPane.showInputDialog("Please enter the employeeID that you want to remove"));
		for (int i = 0; i < facultyMembers.size(); i++) {
			if (remove == (facultyMembers.get(i).getEmployeeId())) {
				facultyMembers.remove(i);
			}
		}
	}

	// show the teaching schedule for faculty
	private void showFacultySchedule() {
		JOptionPane.showMessageDialog(null, copyCourse2);
	}

	// assign courses for faculty (don't know how to assign course for a faculty)
	private void addFacultyCourse() {
		// show what courses is open
		JOptionPane.showMessageDialog(null, courses);
		String courseID = JOptionPane.showInputDialog("Please enter the course ID you want to teach");
		String courseTitle = JOptionPane
				.showInputDialog("Please enter the course title of the course that you want to teach");
		copyCourse2.add(new Course(courseID, courseTitle));
	}

	// delete courses for faculty (don't know how to delete course for a faculty)
	private void deleteFacultyCourse() {
		JOptionPane.showMessageDialog(null, copyCourse2);
		remove = Integer.parseInt(JOptionPane.showInputDialog("Please enter the course ID that you want to drop"));
	}

	// option 3
	private void courseAddDeleteView() {
		String[] choices = { "Quit", "Add", "View" };
		int choice;
		do {
			choice = JOptionPane.showOptionDialog(null, "Option", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null,
					choices, "null");
			switch (choice) {
			case 0:
				break;
			case 1:
				addCourse();
				break;
			case 2:
				if (!(courses.isEmpty()))
					listOfCourse();
				break;
			} // end switch
		} while (choice != 0); // end do
	}

	// asking for the user for input
	private void addCourse() {
		String courseId = JOptionPane.showInputDialog("Please enter the course identifier");
		String courseTitle = JOptionPane.showInputDialog("Please enter the name of the course title");
		courses.add(new Course(courseId, courseTitle));
	}

	// show the list of course
	private void listOfCourse() {
		JOptionPane.showMessageDialog(null, courses);
	}

	// a method that saves the list of attacks to a comma separated values file
	public void saveListOfEverything() {
		File toFile = new File(JOptionPane.showInputDialog("Please enter the path you want to save to: "));

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(toFile));

			for (int j = 0; j < students.size(); j++) {
				writer.write(students.get(j).getCin() + "," + students.get(j).getName() + ","
						+ students.get(j).getStreetNumber() + "," + students.get(j).getStreetName() + ","
						+ students.get(j).getCity() + "," + students.get(j).getState() + ","
						+ students.get(j).getCountry() + "\n");
			}
			for (int j = 0; j < facultyMembers.size(); j++) {
				writer.write(facultyMembers.get(j).getEmployeeId() + "," + facultyMembers.get(j).getName() + ","
						+ facultyMembers.get(j).getStreetNumber() + "," + facultyMembers.get(j).getStreetName() + ","
						+ facultyMembers.get(j).getCity() + "," + facultyMembers.get(j).getState() + ","
						+ facultyMembers.get(j).getCountry() + "\n");
			}
			for (int j = 0; j < courses.size(); j++) {
				writer.write(courses.get(j).getCourseId() + "," + courses.get(j).getCourseTitle() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// a method that remove all the list of student, facultyMember, course and add a csv file instead
	public void deleteAndImport() {
		int employeeId;
		String courseId;
		String courseTitle;
		int cin;
		String name;
		int streetNumber;
		String streetName;
		String city;
		String state;
		String country;
		String name1;
		int streetNumber1;
		String streetName1;
		String city1;
		String state1;
		String country1;
		String line;
		String[] fields;

		File outFile = new File(JOptionPane.showInputDialog("Please enter the path you want to import from: "));

		try {
			students.clear();
			facultyMembers.clear();
			courses.clear();
			Scanner freader = new Scanner(outFile);
			while (freader.hasNextLine()) {
				line = freader.nextLine();
				fields = line.split(",");
				cin = Integer.parseInt(fields[0]);
				name = fields[1];
				streetNumber = Integer.parseInt(fields[2]);
				streetName = fields[3];
				city = fields[4];
				state = fields[5];
				country = fields[6];
				line = freader.nextLine();
				fields = line.split(",");
				employeeId = Integer.parseInt(fields[0]);
				name1 = fields[1];
				streetNumber1 = Integer.parseInt(fields[2]);
				streetName1 = fields[3];
				city1 = fields[4];
				state1 = fields[5];
				country1 = fields[6];
				line = freader.nextLine();
				fields = line.split(",");
				courseId = fields[0];
				courseTitle = fields[1];

				students.add(new Student(cin, name, streetNumber, streetName, city, state, country));
				facultyMembers
						.add(new FacultyMember(employeeId, name1, streetNumber1, streetName1, city1, state1, country1));
				courses.add(new Course(courseId, courseTitle));
			}
			freader.close(); // Close to unlock.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}