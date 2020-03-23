package model;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String website;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Contact() {
	}
	public Contact(int id, String name, String email, String website, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.website = website;
		this.message = message;
	}
	
}
