package com.pato.youtube_api;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    //private variables
    Button btnPlayVid ;
    YouTubePlayerView tubePlayerView;
    YouTubePlayer.OnInitializedListener onInitListener;
    String myVidUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get video url from intent.
        Intent mIntent = getIntent();
        myVidUrl = mIntent.getStringExtra("VID_URL");


        //init the view widgets.
        tubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        btnPlayVid = (Button)findViewById(R.id.btnPlayVid);
//        btnPlayVid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tubePlayerView.initialize("AIzaSyBGGojsqpkgYdLx7w09VS5AuPZVvUdzdS0",onInitListener);
//            }
//        });




        //youtube initialization/
        onInitListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //load the video param: video url
                //youTubePlayer.loadVideo("9ZaEPeaucIU");
                youTubePlayer.loadVideo(myVidUrl);


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };


        //initialize the youtube player here.
        tubePlayerView.initialize("AIzaSyBGGojsqpkgYdLx7w09VS5AuPZVvUdzdS0",onInitListener);
    }

    public void aljezeera_call(View view) {
    }
}
