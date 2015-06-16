package com.example.user.alertdialogwithlists;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button singleButton = (Button) findViewById(R.id.single);
        Button singleChoiceButton = (Button) findViewById(R.id.singleChoice);
        Button multipleChoiceButton = (Button) findViewById(R.id.multipleChoice);

        final String[] colors={"Red", "Blue", "Green", "Violet", "Indigo"};

        singleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("List alert dialog")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"You click Ok", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "You click Cancel", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setItems(colors, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "You click item " + colors[which] + " on position " + which,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })

                        .show();
            }
        });

        singleChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Single-choice alert dialog")
                        .setSingleChoiceItems(colors,1,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "You select item " + colors[which] + " on position " + which,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "You click Cancel", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });


        multipleChoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                final ArrayList selectedItems= new ArrayList();

                alertDialog.setTitle("Multiple-choice alert dialog")
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

                        .setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    selectedItems.add(which);
                                } else if (selectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    selectedItems.remove(Integer.valueOf(which));
                                }



                            }
                        })
                        .setNeutralButton("Show selected", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String temp = "";
                                for (Iterator iterator = selectedItems.iterator(); iterator
                                        .hasNext();) {
                                    Integer object = (Integer) iterator.next();
                                    temp += " " + colors[object];
                                }
                                Toast.makeText(MainActivity.this, temp,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })

                        .show();
            }
        });
    }


}
