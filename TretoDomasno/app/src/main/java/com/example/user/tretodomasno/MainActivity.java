package com.example.user.tretodomasno;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My application");
        actionBar.setIcon(R.drawable.ic_action_important);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case R.id.item1:
                showAlertDialog();
                break;
            case R.id.item2:
                showCustomDialog();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        final String[] niza = {"Facebook", "Twitter", "Instagram", "Linkedin", "Pinterest", "Blogger", "Reddit", "Google+"};

        alertDialog.setTitle("Share via ")
                .setSingleChoiceItems(niza, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You select to share via " + niza[which],
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You click Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You click Ok", Toast.LENGTH_SHORT).show();
                    }
                })
                .show().getWindow().setLayout(480, 500);
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Search");
        dialog.setContentView(R.layout.search_layout);

        Button btn = (Button) dialog.findViewById(R.id.doneBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText= (EditText) dialog.findViewById(R.id.editText);
                dialog.dismiss();
                if(editText.getText().toString().matches("")){

                }
                else{
                    Toast.makeText(MainActivity.this,"You search for " + editText.getText().toString(),Toast.LENGTH_SHORT).show();
                }



            }
        });

        dialog.show();


    }
}
