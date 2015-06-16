package com.example.finaltask;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		final List<Person> lista = new ArrayList<Person>();
		ListView listView = (ListView) findViewById(R.id.listView);
		
		final MyPersonAdapter adapter = new MyPersonAdapter(MainActivity.this, lista);
		listView.setAdapter(adapter);

		Button addBtn = (Button) findViewById(R.id.addBtn);
		Button closeBtn = (Button) findViewById(R.id.clearBtn);
		
		final EditText imeEdit= (EditText) findViewById(R.id.nameEdit);
		final EditText prezimeEdit= (EditText) findViewById(R.id.surnameEdit);
		final EditText adresaEdit= (EditText) findViewById(R.id.addressEdit);
		
		closeBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				imeEdit.setText("");
				prezimeEdit.setText("");
				adresaEdit.setText("");
			}
		});
		
		addBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(imeEdit.getText().toString().matches("") || 
						prezimeEdit.getText().toString().matches("") ||
						adresaEdit.getText().toString().matches("") )
				{
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
					alertDialog.setTitle("Fields Unfilld")
					.setMessage("Please fill all fields")
					.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this, "You click Ok", Toast.LENGTH_SHORT).show();
						}
					})
					.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this, "You click Cancel", Toast.LENGTH_SHORT).show();
							
						}
					})
					.show();
				}
				
				else
				{
					Person person = new Person();
					person.ime=imeEdit.getText().toString();
					person.prezime=prezimeEdit.getText().toString();
					person.adresa=adresaEdit.getText().toString();
					//person.resourceId= findViewById(R.drawable.ic_launcher);
					
					lista.add(person);
					adapter.notifyDataSetChanged();
					imeEdit.setText("");
					prezimeEdit.setText("");
					adresaEdit.setText("");
					
				}
			}
		});
		
		listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int arg2, long arg3) {
				AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(MainActivity.this);
				alertDialog2.setTitle("Delete Person")
				.setMessage("Are you sure want to delete this person?")
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						lista.remove(arg2);
						adapter.notifyDataSetChanged();
						
					}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				})
				.show();
				return false;
			}
		});
		
		
		/*{
			
			@Override
			public boolean onLongClick(View v) {
				AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(MainActivity.this);
				alertDialog2.setTitle("Delete Person")
				.setMessage("Are you sure want to delete this person?")
				.setPositiveButton("No", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				})
				.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						
					}
				})
				.show();
				
				return true;
			}
		});*/
		
	}


}
