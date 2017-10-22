package software;
/*   
Author: Chan In Kou
Purpose: Student is a subclass of Person. In addition to the data inherited from Person, a student has CIN number and a course schedule represented by an ArrayList of Courses (objects of class Course).
*/
public class Student extends Person {
	private int cin;
	
	Student(int cinln, String name, int streetNumber, String streetName, String city, String state, String country) {
		super(name, streetNumber, streetName, city, state, country);
		cin = cinln;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String toString(){
		return "The CIN: " + cin + ", " + super.toString();
	}
}