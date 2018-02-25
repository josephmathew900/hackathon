package com.example.joseph.audioplayer;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button start;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    mediaPlayer[0] = new MediaPlayer();
                    mediaPlayer[0].setAudioAttributes(new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                            .build());
                    try {
                        mediaPlayer[0].setDataSource("https://firebasestorage.googleapis.com/v0/b/hack4people-893ae.appspot.com/o/AudioFiles%2FSat%20Feb%2024%2018%3A44%3A57%20GMT%2B05%3A30%202018?alt=media&token=ec06067a-88bb-4b74-9221-05496fb7c1f6");
                        mediaPlayer[0].prepare();
                        mediaPlayer[0].start();
                        flag =1;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    mediaPlayer[0].stop();
                    mediaPlayer[0].release();
                    flag = 0;
                }}
        });


    }
}
