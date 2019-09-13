package com.example.android.musicplayer;

import android.app.*;
import android.media.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity{
	
	// create media player object
	private MediaPlayer mMediaPlayer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
		
		// set the view to activity_main.xml
        setContentView(R.layout.activity_main);
		
		mMediaPlayer = MediaPlayer.create(this, R.raw.phrases_coming);
		
		Button playButton = (Button) findViewById(R.id.play_button);
		playButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				mMediaPlayer.start();
				mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

						@Override
						public void onCompletion(MediaPlayer mp){
							Toast.makeText(MainActivity.this, "I'm Done", Toast.LENGTH_SHORT).show();
						}
				});
			}
		});

		Button pauseButton = (Button) findViewById(R.id.pause_button);
		pauseButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				mMediaPlayer.pause();
			}
		});
		
    }
	
}
