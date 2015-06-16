package com.example.db_task;

import java.util.List;

public interface PersonCRUDInterface {
	public void createNewPerson(Person person);
	public void updateExistingPerson(Person person);
	public void deleteExistingPerson(Person person);
	public Person findSpecificPersonByID(Integer personID);
	public List<Person>findAllPersonObjects();

}
