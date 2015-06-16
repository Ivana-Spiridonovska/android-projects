package com.example.task2;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment {


    MyInterface myInterface;
    FragmentManager fragmentManager = getFragmentManager();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);
        Button nextFragment = (Button) view.findViewById(R.id.goToNextFragment);
        final EditText fragmentText = (EditText) view.findViewById(R.id.nextFragmentText);
        TextView textView = (TextView) view.findViewById(R.id.textFromSecondFragment);

        nextFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myInterface.callFragmentTwo(fragmentText.getText().toString());
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            String text = bundle.getString("text1");
            textView.setText(text);
        }

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

