package com.example.custom_component_solution;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements CallbackControl {

	private CustomUIComponent component = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}

	private void initView() {
		component = (CustomUIComponent) findViewById(R.id.component);
		
		component.login();
		
		TextView animator = (TextView) findViewById(R.id.animator);
		animator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.translatein));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void buttonPressed(String text, String password) {
		Toast.makeText(this, "Username: " + text + " Password: " + password, Toast.LENGTH_SHORT).show();
	}

	public void changeEditTextValue(View v) {
		component.setHintToEditText();
	}
}
