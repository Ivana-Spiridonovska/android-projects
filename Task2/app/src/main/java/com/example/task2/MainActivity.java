package com.example.task2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity{

	protected static final int requestCode = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    Button next= (Button) findViewById(R.id.nextButton);
	    final EditText title =(EditText) findViewById(R.id.editTitle);
	    final EditText description =(EditText) findViewById(R.id.editDescription);
	    
	    next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				intent.putExtra("pushTitle", title.getText().toString());
				intent.putExtra("pushDescription", description.getText().toString());
				startActivity(intent);
			}
		});
		
	}

	
}
