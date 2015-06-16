package com.example.task2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {

    MyInterface myInterface;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.second_fragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textFragment);
        final EditText editText = (EditText) view.findViewById(R.id.textToFirstFragment);
        Button button = (Button) view.findViewById(R.id.goToFirstFragment);

        Bundle bundle= getArguments();
        if (bundle!=null){
            String string = bundle.getString("text");
            textView.setText(string);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myInterface.callFragmentOne(editText.getText().toString());
            }
        });
		return view;
	}

    @Override
    public void onAttach(Activity activity) {
        try {
            this.myInterface = (MyInterface) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        super.onAttach(activity);
    }
}
