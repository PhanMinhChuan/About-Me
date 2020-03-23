package model;

public class Skill {

	private int id;
	private String name;
	private int finish;
	
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
	
	

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public Skill() {
	}

	public Skill(int id, String name, int finish) {
		super();
		this.id = id;
		this.name = name;
		this.finish = finish;
	}

}
