package com.example.task2;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity implements MyInterface {
    String title, description;
    FragmentManager fragmentManager = getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        TextView textTitle = (TextView) findViewById(R.id.textTitle);
        TextView textDescriptor = (TextView) findViewById(R.id.textDescription);

        Button previous = (Button) findViewById(R.id.previous);
        Button next = (Button) findViewById(R.id.next);

        // za da se zemat podatoci od mainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("pushTitle");
            textTitle.setText(title);

            description = extras.getString("pushDescription");
            textDescriptor.setText(description);
        }


        previous.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FirstFragment firstFragment = new FirstFragment();
                if (firstFragment.isAdded()) {
                    fragmentTransaction.show(firstFragment);
                } else {
                    fragmentTransaction.replace(R.id.fragmentLayout, firstFragment);
                    //fragmentTransaction.addToBackStack("Some string");
                }
                fragmentTransaction.commit();
            }
        });

        next.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SecondFragment secondFragment = new SecondFragment();
                if (secondFragment.isAdded()) {
                    fragmentTransaction.show(secondFragment);
                } else {
                    fragmentTransaction.replace(R.id.fragmentLayout, secondFragment);
                }
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public void callFragmentTwo(String data) {

        FragmentManager fragmentManager = getFragmentManager();
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", data);
        secondFragment.setArguments(bundle);

        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, secondFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void callFragmentOne(String data) {
        FragmentManager fragmentManager1 = getFragmentManager();
        FirstFragment firstFragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text1", data);
        firstFragment.setArguments(bundle);

        android.app.FragmentTransaction fragmentTransaction = fragmentManager1.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout,firstFragment);
        fragmentTransaction.commit();

    }


}
