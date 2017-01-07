package com.menger.entity;

import java.sql.Blob;

public class Contact {

	private String id; // id是唯一的，自动生成的，唯一代表一条记录
	private String name; // 名字
	private String gender; // 性别
	private int age; // 年龄
	private String jiguan; // 籍贯
	private String qq; // qq
	private String email;
	private Blob photo;

	public Contact() {
		super();
	}

	public Contact(String id, String name, String gender, int age,
			String jiguan, String qq, String email) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.jiguan = jiguan;
		this.qq = qq;
		this.email = email;
	}

	public Contact(String id, String name, String gender, int age,
			String jiguan, String qq, String email, Blob photo) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.jiguan = jiguan;
		this.qq = qq;
		this.email = email;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJiguan() {
		return jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", jiguan=" + jiguan + ", qq=" + qq + ", email=" + email + "]";
	}

}
