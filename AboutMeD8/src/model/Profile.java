package model;

import java.sql.Date;

public class Profile {
	private String name;
	private int tuoi;
	private String ngaySinh;
	private String diaChi;
	private int sdt;
	private String picture;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public Profile() {
	}

	public Profile(String name, int tuoi, String ngaySinh, String diaChi, String picture, String email) {
		super();
		this.name = name;
		this.tuoi = tuoi;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.picture = picture;
		this.email = email;
	}

	public Profile(String name, int tuoi, String ngaySinh, String diaChi, int sdt, String picture, String email) {
		super();
		this.name = name;
		this.tuoi = tuoi;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.picture = picture;
		this.email = email;
	}
	
}
