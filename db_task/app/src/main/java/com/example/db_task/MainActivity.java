package com.example.db_task;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private PersonCRUDInterface personCRUD = null;
	protected Context context;

    private List<Person> personsList;
    private PersonAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText name = (EditText) findViewById(R.id.personName);
		final EditText surname = (EditText) findViewById(R.id.personSurname);
		final EditText address = (EditText) findViewById(R.id.personAddress);
		
		Button refresh = (Button) findViewById(R.id.refreshButton);
		Button submit = (Button) findViewById(R.id.submitButton);
		final ListView listView = (ListView) findViewById(R.id.listView1);
		
		personCRUD = PersonCRUD.getInstance(MainActivity.this);
		final Person persons = new Person();

       /* final List<Person> personsList = PersonCRUD.getInstance(context).findAllPersonObjects();
        PersonAdapter adapter = new PersonAdapter(MainActivity.this, personsList);
        listView.setAdapter(adapter);*/

		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				persons.setName(name.getText().toString());
				persons.setSurname(surname.getText().toString());
				persons.setAddress(address.getText().toString());
				persons.setDeleted(0);
				personCRUD.createNewPerson(persons);
				name.setText("");
				surname.setText("");
				address.setText("");
				
			}
		});
		
		refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                personsList = personCRUD.findAllPersonObjects();
                adapter = new PersonAdapter(MainActivity.this, personsList);
                listView.setAdapter(adapter);
			}
		});
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(final AdapterView<?> arg0, View arg1,
					final int arg2, long arg3) {
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
				alertDialog.setTitle("Delete person!")
				.setMessage("Are you sure you want to delete that person?")
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//Toast.makeText(MainActivity.this, "You click Ok", Toast.LENGTH_SHORT).show();
                        Person deletePerson = personCRUD.findSpecificPersonByID(arg2);
						personCRUD.deleteExistingPerson(deletePerson);
                        adapter.notifyDataSetChanged();
					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "You click Cancel", Toast.LENGTH_SHORT).show();
					}
				})
				.show();
				return false;
			}
		});
	}
}
