package model;

public class Comment {
	private int id;
	private String name;
	private String email;
	private String message;
	private String dateCreate;
	private int id_cat;
	
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}
	
	
	public Comment(int id, String name, String email, String message, String dateCreate, int id_cat) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.dateCreate = dateCreate;
		this.id_cat = id_cat;
	}
	public Comment() {
	}
	
	
}
