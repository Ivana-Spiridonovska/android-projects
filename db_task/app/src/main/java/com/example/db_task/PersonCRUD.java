package com.example.db_task;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonCRUD implements PersonCRUDInterface {

	private static PersonCRUD instance = null;
	private Context context = null;

	private PersonCRUD(Context context) {
		this.context = context;
	}

	public static PersonCRUD getInstance(Context context) {
		if (instance == null) {
			instance = new PersonCRUD(context);
		}

		return instance;
	}

	@Override
	public void createNewPerson(Person person) {
		DBHelper dbHelper = DBHelper.getInstance(context);

		ContentValues contentValues = new ContentValues();
		contentValues.put(DBHelper.COLUMN_NAME_NAME, person.getName());
		contentValues.put(DBHelper.COLUMN_NAME_SURNAME, person.getSurname());
		contentValues.put(DBHelper.COLUMN_NAME_ADDRESS, person.getAddress());
		contentValues.put(DBHelper.COLUMN_NAME_DELETED, person.getDeleted());

		SQLiteDatabase db = dbHelper.getDB();
		db.insert(DBHelper.TABLE_NAME_PERSON, null, contentValues);
	}

	@Override
	public void updateExistingPerson(Person person) {
		DBHelper dbHelper = DBHelper.getInstance(context);

		ContentValues contentValues = new ContentValues();
		contentValues.put(DBHelper.COLUMN_NAME_NAME, person.getName());
		contentValues.put(DBHelper.COLUMN_NAME_SURNAME, person.getSurname());
		contentValues.put(DBHelper.COLUMN_NAME_ADDRESS, person.getAddress());
		contentValues.put(DBHelper.COLUMN_NAME_DELETED, person.getDeleted());
		
		dbHelper.getDB().update(DBHelper.TABLE_NAME_PERSON, 
				contentValues, "_id=" + person.getId(), null);

	}

	@Override
	public void deleteExistingPerson(Person person) {
		DBHelper.getInstance(context).getDB().delete(DBHelper.TABLE_NAME_PERSON, "_id=" + person.getId(), null);

	}

	@Override
	public Person findSpecificPersonByID(Integer personID) {
		DBHelper dbHelper = DBHelper.getInstance(context);
		
		Person person = null;
		Cursor cursor = dbHelper.getDB().query(DBHelper.TABLE_NAME_PERSON, null, "_id="+personID, null, null, null, null);
		
		if (cursor != null && cursor.moveToFirst()) {
			person = new Person();
			
			person.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_ID)));
			person.setName(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_NAME)));
			person.setSurname(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_SURNAME)));
			person.setAddress(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_ADDRESS)));
			person.setDeleted(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_DELETED)));
			
		}
		return person;
	}

	@Override
	public List<Person> findAllPersonObjects() {
		DBHelper dbHelper = DBHelper.getInstance(context);
		List<Person>personList = null;
		
		Person person = null;
		
		Cursor cursor = dbHelper.getDB().query(DBHelper.TABLE_NAME_PERSON, null, null, null, null, null, "_id DESC");
		cursor.moveToFirst();
		
		if (cursor != null) {
			personList = new LinkedList<Person>();
			do {
				person = new Person();
				
				person.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_ID)));
				person.setName(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_NAME)));
				person.setSurname(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_SURNAME)));
				person.setAddress(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_ADDRESS)));
				person.setDeleted(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_DELETED)));
			
				personList.add(person);
			} while (cursor.moveToNext());
			
		}
		
		return personList;
	}

}
