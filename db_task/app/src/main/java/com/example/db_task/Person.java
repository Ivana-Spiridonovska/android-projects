package com.example.db_task;

import android.content.ContentValues;

public class Person {

	private Integer id;
	private String name;
	private String surname;
	private String address;
	private Integer deleted;

	public Person() {
	}

	public Person(Integer id, String name, String surname, String address,
			Integer deleted) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.deleted = deleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public ContentValues returnAsContentValue() {
		ContentValues contentValues = new ContentValues();
		contentValues.put(DBHelper.COLUMN_NAME_NAME, this.name);
		contentValues.put(DBHelper.COLUMN_NAME_SURNAME, this.surname);
		contentValues.put(DBHelper.COLUMN_NAME_ADDRESS, this.address);
		contentValues.put(DBHelper.COLUMN_NAME_DELETED, this.deleted);

		return contentValues;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", address=" + address + ", deleted=" + deleted + "]";
	}
}
