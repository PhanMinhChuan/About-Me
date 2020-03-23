package model;

import java.sql.Timestamp;

public class New {
	private int id;
	private String name;
	private String preview_text;
	private String detail_text;
	private Timestamp date_create;
	private int counter;
	private int cat_id;
	private String picture;
	private String catName;
	
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

	public String getPreview_text() {
		return preview_text;
	}

	public void setPreview_text(String preview_text) {
		this.preview_text = preview_text;
	}

	public String getDetail_text() {
		return detail_text;
	}

	public void setDetail_text(String detail_text) {
		this.detail_text = detail_text;
	}

	public Timestamp getDate_create() {
		return date_create;
	}

	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public New() {
	}
	
	public New(int id, String name, String preview_text, String detail_text, Timestamp date_create, int counter, int cat_id) {
		this.id = id;
		this.name = name;
		this.preview_text = preview_text;
		this.detail_text = detail_text;
		this.date_create = date_create;
		this.counter = counter;
		this.cat_id = cat_id;
	}
	
	public New(int id, String name, String preview_text, String detail_text, Timestamp date_create, int counter, int cat_id, String picture, String catName) {
		this.id = id;
		this.name = name;
		this.preview_text = preview_text;
		this.detail_text = detail_text;
		this.date_create = date_create;
		this.counter = counter;
		this.cat_id = cat_id;
		this.picture = picture;
		this.catName = catName;
	}
	
}
