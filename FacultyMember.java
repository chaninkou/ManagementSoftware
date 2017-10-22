package software;
/*   
Author: Chan In Kou
Purpose: FacultyMember is also subclass of Person and it has an employee id number and a teaching schedule, which is an ArrayList of Courses. It assign a FacultyMember to teach an existing Course.
*/
public class FacultyMember extends Person {
	private int employeeId;

	FacultyMember(int employeeIdln, String name,int streetNumber, String streetName, String city, String state, String country) {
		super(name, streetNumber, streetName, city, state, country);
		employeeId = employeeIdln;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String toString() {
		return "The emplyeeId: " + employeeId + ", " +super.toString();

	}
}