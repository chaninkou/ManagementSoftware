package software;
/*   
Author: Chan In Kou
Purpose: An address has a street number, street name, city, state or province, and country.
*/
public class Address {
	protected int streetNumber;
	protected String streetName;
	protected String city;
	protected String state;
	protected String country;

	public Address(int streetNumberIn, String streetNameIn, String cityIn, String stateIn, String countryIn) {
		streetNumber = streetNumberIn;
		streetName = streetNameIn;
		city = cityIn;
		state = stateIn;
		country = countryIn;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return streetNumber + streetName + city + state + country;
	}
	
}