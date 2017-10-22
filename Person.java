package software;
/*   
Author: Chan In Kou
Purpose: A Person has a name and an Address represented by an object of class Address, not a String. The subclasses of Person will inherit the fields and methods of Person.
*/
public class Person extends Address {
	private String name;
	
	Person(String nameln, int streetNumber, String streetName, String city, String state, String country) {
		super(streetNumber, streetName, city, state, country);
		name = nameln;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return " Name: " + name + ", StreetNumber: " + streetNumber + ", StreetName: " + streetName + ", City: " + city + ", State: " + state + ", Country: " + country;
	}	
}