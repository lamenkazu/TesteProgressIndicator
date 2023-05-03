package com.example.testeprogressindicator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearProgressIndicator pgrIndicator = findViewById(R.id.linear);

        Timer timer = new Timer();


        TimerTask task = new TimerTask() {
            int progress;
            @Override
            public void run() {

                progress += 1;

                pgrIndicator.setProgressCompat(progress, true);


                if(progress == 100){
                    timer.cancel();
                }
            }
        };

        timer.schedule(task, 500, 85);


        pgrIndicator.setProgressCompat(50, true);
    }
}