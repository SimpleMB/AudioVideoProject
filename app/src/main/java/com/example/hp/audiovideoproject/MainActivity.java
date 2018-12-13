package com.example.hp.audiovideoproject;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private VideoView myVideoView;                          // setting new variable of VideoView type
    private Button btnPlay, btnPlayMusic, btnPauseMusic;    //
    private MediaController mediaControler;                 // setting new variable of MediaController type
    private MediaPlayer myMusic;                            // mediaplayer obj for music files
    private SeekBar seekBarVolume, seekBarMove;             // seek bar for Volume
    private AudioManager audioManager;                      // loading Audio manager service
    private Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.myVideoView);                       // initializing VideoView with layout id
        btnPlay = findViewById(R.id.btnPlay);                               // initializing buttons with layout ids
        btnPlayMusic = findViewById(R.id.btnPlayMusic);
        btnPauseMusic = findViewById(R.id.btnPauseMusic);
        seekBarVolume = findViewById(R.id.seekBarVolume);
        seekBarMove = findViewById(R.id.seekBarMove);


//        btnPlay.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View vid) {
//
//                myVideoView.start();        // start playing video
//
//            }
//        });                      // setting onClickListeners to buttons
//
//
//        btnPlayMusic.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View music) {
//
//                myMusic.start();            //start playing music
//
//            }
//        });
//
//
//        btnPauseMusic.setOnClickListener (new View.OnClickListener() {
//            @Override
//            public void onClick(View pause) {
//
//                myVideoView.pause();
//                myMusic.pause();
//
//            }
//        });

        mediaControler = new MediaController(MainActivity.this);    // creating new media controller object
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);      // creating (getting) new Audio Service


        int maximumVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBarVolume.setMax(maximumVol);
        seekBarVolume.setProgress(currentVol);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Uri uriVid = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.power);   // setting path to video file in res/raw folder
        // and adding it to new variable of type Uri
        myVideoView.setVideoURI(uriVid);                    // adding file from path to VideoView
        myVideoView.setMediaController(mediaControler);     // add media controller to VideoView
        mediaControler.setAnchorView(myVideoView);          // anchor media controller to VideoView

        Uri uriMusic = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.carefree);
        myMusic = MediaPlayer.create(MainActivity.this, uriMusic);

    }

        // Seek Bar for progress of playing

//        seekBarMove.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });            // thanks to implementing interface SeekBar.OnSeekBarChangeListener
//                                                                                // in MainActivity class we only have to activate setOnSeekBarChangeListener
//        seekBarMove.setMax(myMusic.getDuration());
//
//    }
//

//    public void btnClicked (View view) {
//
//        switch (btnIsClicked.getId()) {
//
//            case R.id.btnPlay:
//                myVideoView.start();        // start playing video
//                break;
//            case R.id.btnPlayMusic:
//                myMusic.start();            //start playing music
////                timer = new Timer();
////                timer.scheduleAtFixedRate(new TimerTask() {
////                    @Override
////                    public void run() {
////
////                        seekBarMove.setProgress(myMusic.getCurrentPosition());
////                    }
////                }, 0, 1000);
////                break;
//            case R.id.btnPauseMusic:
//                myVideoView.pause();        //video paused
//                myMusic.pause();            //music paused
////                timer.cancel();             // cancels timer progress thread
//                break;
//        }

//
//    @Override
//    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//        if (fromUser) {
//              audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
//
//        }
//    }
//
//    @Override
//    public void onStartTrackingTouch(SeekBar seekBar) {
//
//    }
//
//    @Override
//    public void onStopTrackingTouch(SeekBar seekBar) {
//
//    }

    public void btnClicked (View btnIsClicked) {

        switch (btnIsClicked.getId()) {

            case R.id.btnPlay:
                myVideoView.start();        // start playing video
                break;
            case R.id.btnPlayMusic:
                myMusic.start();            //start playing music
//                timer = new Timer();
//                timer.scheduleAtFixedRate(new TimerTask() {
//                    @Override
//                    public void run() {
//
//                        seekBarMove.setProgress(myMusic.getCurrentPosition());
//                    }
//                }, 0, 1000);
                break;
            case R.id.btnPauseMusic:
                myVideoView.pause();        //video paused
                myMusic.pause();            //music paused
//                timer.cancel();             // cancels timer progress thread
                break;
        }

    }
}
