package com.example.sarathkumar.audionew;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.media.MediaPlayer;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mPlay;
    AudioManager audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        mPlay = MediaPlayer.create(this, R.raw.laugh);

        audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int Max = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int Cur = audio.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar Vol = (SeekBar) findViewById(R.id.seekBar);

        Vol.setMax(Max);
        Vol.setProgress(Cur);


        Vol.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //  Log.i("**********",Integer.toString(progress));

                audio.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
        });

        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        final SeekBar scrub = (SeekBar) findViewById(R.id.Scrub);
        scrub.setMax(mPlay.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrub.setProgress(mPlay.getCurrentPosition());
            }
        },0,1000);

        scrub.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                mPlay.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



















    }

    public void play(View view)
    {

        mPlay.start();

    }


    public void pause(View view)
    {
        mPlay.stop();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
