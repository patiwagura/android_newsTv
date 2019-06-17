package com.pato.youtube_api;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Channels_Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnAljezera, btnK2, btnK24;
    private final String VID_URL = "VID_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channels_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create references to the menu_buttons.
        btnAljezera =(Button)findViewById(R.id.btnAljezera);
        btnK2 = (Button) findViewById(R.id.btnCitizen);
        btnK24 = (Button)findViewById(R.id.btnK24);

        //set action listeners for the buttons.
        btnAljezera.setOnClickListener(this);
        btnK24.setOnClickListener(this);
        btnK2.setOnClickListener(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Going back to Main Activity", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //go back to menu_activity.
                Intent showMainAct = new Intent(Channels_Activity.this, MainActivity.class);
                startActivity(showMainAct);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btnAljezera:
                //aljezeera clicked.
                showVidActivity("jL8uDJJBjMA");
                break;

            case R.id.btnK24:
                showVidActivity("3g1ut_11xw0");
                break;
            case R.id.btnCitizen:
                showVidActivity("xnUKJbUZoQM");
                break;

        }

    }

    //method called to show the Activity with youtubeApi.
    public void showVidActivity(String mVidUrl){
        Intent shoVidIntent = new Intent(Channels_Activity.this, MainActivity.class);
        shoVidIntent.putExtra(VID_URL,mVidUrl);
        startActivity(shoVidIntent);

    }

}
