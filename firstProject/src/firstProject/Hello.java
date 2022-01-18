package firstProject;

public class Hello {

	private String firstName;
	private String lastName;
	public Hello(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;	
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void greet() {
		System.out.printf("Hello %s %s", firstName, lastName);
	}
}