package com.example.kelompok3.pmo2_pert2;

import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.media.MediaPlayer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;

    VideoView video;
    Button main1,main2,stream,mainvid,stop,music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        video = findViewById(R.id.video);
        main1 = findViewById(R.id.main1);
        main2 = findViewById(R.id.main2);
        stream = findViewById(R.id.main_streaming);
        mainvid = findViewById(R.id.main_video);
        stop = findViewById(R.id.hentikan);
        music = findViewById(R.id.music);

        video.setOnClickListener(this);
        main1.setOnClickListener(this);
        main2.setOnClickListener(this);
        stream.setOnClickListener(this);
        mainvid.setOnClickListener(this);
        stop.setOnClickListener(this);
        music.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main1:
                try{
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }catch (Exception e){

                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.nice_song);
                mediaPlayer.start();

                break;
            case R.id.main2:
                try{
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }catch (Exception e){

                }
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.nice_song);
                mediaPlayer.start();
                break;
            case R.id.main_streaming:
                try{
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }catch (Exception e){

                }
                String url = "http://www.virginmegastore.me/Library/Music/CD_001214/Tracks/Track1.mp3";
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try{
                    mediaPlayer.setDataSource(url);
                }catch (IllegalArgumentException e){

                }catch (IllegalStateException e){

                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                break;
            case R.id.main_video:
                    try{
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }catch (Exception e){

                    }
                    MediaController mediaController = new MediaController(this);
                    mediaController.setAnchorView(video);

                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.nice_video);
                    video.setMediaController(mediaController);
                    video.setVideoURI(uri);
                    video.requestFocus();
                    video.start();

                    break;
            case R.id.hentikan:
                try{
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }catch (Exception e){

                }
                break;
            case R.id.music:
                startActivity(new Intent(this,music_player.class));
                break;

        }
    }
}
